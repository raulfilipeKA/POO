package projeto.pt.iscte.poo.game;

import projeto.objects.*;
import projeto.pt.iscte.poo.gui.ImageGUI;
import projeto.pt.iscte.poo.utils.Direction;
import projeto.pt.iscte.poo.utils.Point2D;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class Room {
	
	//private Point2D heroStartingPosition = new Point2D(1, 1);
	private JumpMan jumpMan;
	// config fica na porta
	//private static ArrayList<Room> roomList = new ArrayList<>();
	//private static int currentRoom = 0; todo: meter no engine
	private ArrayList<GameObject> roomObjectsList;

	public Point2D getJumpManPosition() {
		return jumpMan.getPosition();
	}

	public ArrayList<GameObject> getRoomObjectsList() {
		return roomObjectsList;
	}

	public Room(int n) throws FileNotFoundException {
		roomObjectsList = new ArrayList<>();
		File[] files = new File("rooms").listFiles();
		char[][] room = createMatrix(files[n]);
		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < room[i].length; j++) {
				roomObjects(room[i][j], i, j);
			}
		}
		//roomList.add(this); todo meter no engine?
	}

	public void roomObjects(char object, int i, int j){
		Point2D position = new Point2D(i, j);
		GameObject obj;
		switch (object) {
			case 'W':
				obj = new Wall(position);
				roomObjectsList.add(obj);
				return;
			case 'H':
				jumpMan = new JumpMan(position);
				return;
			case 'G':
				obj = new Kong(position);
				roomObjectsList.add(obj);
				return;
			case 'S':
				obj = new Stairs(position);
				roomObjectsList.add(obj);
				return;

			case 'm':
				obj = new GoodMeat(position);
				roomObjectsList.add(obj);
				return;
			case '0':
				obj = new DoorClosed(position);
				roomObjectsList.add(obj);
				return;

			case 't':
				obj = new Trap(position);
				roomObjectsList.add(obj);
				return;

						}


	}


	public static char[][] createMatrix(File file) throws FileNotFoundException{ //matriz para imagem em xy
		char[][] matrix = new char[10][10];
		Scanner sc = new Scanner(file);
		sc.nextLine(); //config.add(sc.nextLine());


		int y = 0;
		while (sc.hasNextLine() && y < matrix.length) {
				String line = sc.nextLine();
				for (int x = 0; x < matrix[y].length; x++) {
					matrix[x][y] = line.charAt(x);
				}
				y++;
		}
		return matrix;
	}

	public void moveKong() {//if level is <4, move randomly
		for (GameObject possibleKong : roomObjectsList) {
			if(possibleKong instanceof Kong) {
				((Kong) possibleKong).move(); //se tiver assim, nao da para aceder a posicao e nao consigo invocar isValidMove
			}
		}
	}


	public void moveKong(Point2D p) {
		Kong kong;
		for (GameObject possibleKong : roomObjectsList) {
			if(possibleKong instanceof Kong) {
				kong = (Kong) possibleKong;
				//for (GameObject obstaculos : roomObjectsList) {
				if (!isValidMove(p)) {return;}
				//}
				kong.move(p);
				//kong.setPosition(p); //tinha que colocar setPosition public em GameObject
			}
		}
	}


	public void moveJumpMan(int k) {

		for (GameObject object : roomObjectsList) {
			if (!isValidMove(jumpMan.getPosition().plus(Direction.directionFor(k).asVector())))
				//|| object.getPosition().equals(jumpMan.getPosition().plus(Direction.directionFor(k).asVector()))
			{return;}
		}
		jumpMan.move(Direction.directionFor(k));

	}

	protected boolean isValidMove(Point2D newPosition){
		for(GameObject object : roomObjectsList){
			if((object instanceof Wall && object.getPosition().equals(newPosition))
			|| newPosition.getX() < 0 || newPosition.getX() >= 10
			|| newPosition.getY() < 0 || newPosition.getY() >= 10

			) {	return false;}
		}
		return true;
	}

//	public static void changeRoom(int newRoomIndex) {
//		if (newRoomIndex >= 0 && newRoomIndex < roomListMatrix.size()) {
//			currentRoom = newRoomIndex;
//			new Room();
//		} else {
//			throw new IllegalArgumentException("Índice de sala inválido!");
//		}
//	} todo: meter no engine

//
//    }
//}
	
}