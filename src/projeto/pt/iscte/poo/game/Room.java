package projeto.pt.iscte.poo.game;

import projeto.objects.Character;
import projeto.objects.*;
import projeto.pt.iscte.poo.gui.ImageGUI;
import projeto.pt.iscte.poo.utils.Direction;
import projeto.pt.iscte.poo.utils.Point2D;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Room {
	
	//private Point2D heroStartingPosition = new Point2D(1, 1);
	private JumpMan jumpMan;
	// config fica na porta
	//private static ArrayList<Room> roomList = new ArrayList<>();
	//private static int currentRoom = 0; todo: meter no engine
	private ArrayList<GameObject> roomObjectsList;
	//private String doorConfig;
	private boolean needsKey=false;

	public Point2D getJumpManPosition() {
		return jumpMan.getPosition();
	}

	public ArrayList<GameObject> getRoomObjectsList() {
		return roomObjectsList;
	}

	public Room(int n) {
		try{
		roomObjectsList = new ArrayList<>();
		File[] files = new File("rooms").listFiles();
		char[][] room = createMatrix(files[n]);
		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < room[i].length; j++) {
				roomObjects(room[i][j], i, j);
			}
		}
		}catch (FileNotFoundException _) {
			System.out.println("Ficheiro não encontrado");
		}
		//roomList.add(this); todo meter no engine?
	}

	public void roomObjects(char object, int i, int j){ //no fim apagar isto e passar cada simbolo para  cada objeto
		Point2D position = new Point2D(i, j);
		GameObject obj;
//		obj = new Floor(position);
//		roomObjectsList.add(new Floor(position));

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
			case 'k':
				obj = new Key(position);
				roomObjectsList.add(obj);
				needsKey = true;
				return;

			case 's':
				obj = new Sword(position);
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

//	public void moveKong() {//if level is <4, move randomly
//		for (GameObject possibleKong : roomObjectsList) {
//			if(possibleKong instanceof Kong) {
//				((Kong) possibleKong).move(); //se tiver assim, nao da para aceder a posicao e nao consigo invocar isValidMove
//			} //todo isValidMove
//		}
//	}


	public void moveKong() {//if level is <4, move randomly
		Kong kong;
		Point2D p;
		for (GameObject possibleKong : roomObjectsList) {
			if(possibleKong instanceof Kong) {
				kong = (Kong) possibleKong;
				p = kong.getPosition().plus(Direction.random().asVector());
				//for (GameObject obstaculos : roomObjectsList) {

					if (isValidMove(p)){
						kong.move(p);
						kong.deployProjectile(new Banana(p));
					}

				//	System.out.println("Kong: THUND");
				//}
				//}
				//kong.setPosition(p); //tinha que colocar setPosition public em GameObject
			}
		}
	}


	public void moveKong(Point2D p) {
		Kong kong;
		for (GameObject possibleKong : roomObjectsList) {
			if(possibleKong instanceof Kong) {
				kong = (Kong) possibleKong;
				//for (GameObject obstaculos : roomObjectsList) {
				//todo fazer a mesma logica do movimento em cima com o try catch para nao rebentar com o movimento invalido
				try {
					if (isValidMove(p)) kong.move(p);
				} catch (IllegalArgumentException _) {
					System.out.println("O Kong bateu com a cabeça");
				}
				//}
				kong.move(p);
				//kong.setPosition(p); //tinha que colocar setPosition public em GameObject
			}
		}
	}

	public void moveJumpMan(int k) {

		//jumpMan.setWayIsFacing(k);
		Direction d = Direction.directionFor(k);
		if(isValidMove(jumpMan.getPosition().plus(d.asVector())) && whatsThere(jumpMan.getPosition().plus(d.asVector())) instanceof Item){
			jumpMan.move(d);
			//jumpMan.pickUp(whatsThere(jumpMan.getPosition().plus(d.asVector())));
		}
		else if(isValidMove(jumpMan.getPosition().plus(d.asVector())) && whatsThere(jumpMan.getPosition().plus(d.asVector())) instanceof Item){
			jumpMan.attack((Character) whatsThere(jumpMan.getPosition().plus(d.asVector())));
			//jumpMan.pickUp(whatsThere(jumpMan.getPosition().plus(d.asVector())));
		}

		else if (whatsThere(jumpMan.getPosition().plus(d.asVector())) instanceof Character ){
			Character character = (Character) whatsThere(jumpMan.getPosition().plus(d.asVector()));
			jumpMan.attack(character);
			if(character.getHealth() <= 0) {roomObjectsList.remove(character);}
		}

		else if (isValidMove(jumpMan.getPosition().plus(d.asVector()))) {
			jumpMan.move(Direction.directionFor(k));
		}
	}



	protected boolean isValidMove(Point2D newPosition){
		for(GameObject object : roomObjectsList){
			if(((object instanceof Wall || object instanceof Character || object instanceof Trap)
					&& object.getPosition().equals(newPosition))
			|| newPosition.getX() < 0 || newPosition.getX() >= 10
			|| newPosition.getY() < 0 || newPosition.getY() >= 10

			) {	return false;}
		}
		return true;
	}

	protected GameObject whatsThere(Point2D position) {
		for (GameObject object : roomObjectsList) {
			if (object.getPosition().equals(position)) {
				return object;
			}
		}
		return null;
	}

	public boolean isFinished() {
		for (GameObject object : roomObjectsList) {
			if (object instanceof DoorOpen && object.getPosition().equals(jumpMan.getPosition())) {
				return true;
			}
		}
		return false;
	}

	// verificar se apanha a chave, se sim remove a chave e passa o atributo hasKey
	// do jumpman para true
	public void catchKey() {
		for (GameObject object : roomObjectsList) {
			if (object instanceof Key && object.getPosition().equals(jumpMan.getPosition())) {
				jumpMan.setHasKey(true);
				// estou a assumir que so irá existir uma chave por sala
				// (caso contenha mais keys por sala tenho de fazer um for com o int i para
				// obter a posição correta do objeto)
				roomObjectsList.remove(object);
				ImageGUI.getInstance().removeImage(object);
				return;
			}
		}
	}

//-------------------------------FUNCIONA-------------------------------
//----------------------------------|||---------------------------------
//----------------------------------VVV---------------------------------

// verficar se o objeto é uma doorClosed e se esta na mesma posição que o
// jumpman e retorna o objeto
	public DoorClosed atDoor() {
		for (GameObject object : roomObjectsList) {
			if (object instanceof DoorClosed && object.getPosition().equals(jumpMan.getPosition())
			&& jumpMan.hasKey()) {
				return (DoorClosed) object;
			}
		}
		return null;
	}

//o metodo atDoor funciona
//	public boolean atDoor() {
//	for (GameObject object : roomObjectsList) {
//		if (object instanceof DoorClosed && object.getPosition().equals(jumpMan.getPosition())) {
//			return true;
//		}
//	}
//	return false;
//}



	public void trocarPorta() {
		// verificar se o atributo do jumpma.haskey é valido validos
		if (jumpMan.hasKey()) {
			// atribuir a door o objeto doorClosed
			DoorClosed door = atDoor();
			if (door != null) {
				// susbtituir na lista na posicção onde estava o objeto pelo novo objeto
				// (doorOpen),ao fazer o indexOf estou a assumir que só existe uma porta
				roomObjectsList.set(roomObjectsList.indexOf(door), new DoorOpen(door.getPosition()));
				jumpMan.setHasKey(false);
				ImageGUI.getInstance().removeImage(door);
			}
		}

	}



	public JumpMan getJumpMan() {return jumpMan;}

}