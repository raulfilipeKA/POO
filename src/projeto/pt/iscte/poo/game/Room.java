package projeto.pt.iscte.poo.game;

import projeto.objects.*;
import projeto.objects.Character;
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
	private static ArrayList<String> config = new ArrayList<>();
	private static ArrayList<char[][]> roomListMatrix = new ArrayList<>();
	private static ArrayList<Room> roomList = new ArrayList<>();
	private static int currentRoom = 0;
	

	static {
		try {
			File[] files = new File("rooms").listFiles();
			for (File file : files) {
				roomListMatrix.add(createMatrix(file));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	//	public Room() {
//		jumpMan = new JumpMan(heroStartingPosition, 100, 10);
//		ImageGUI.getInstance().addImage(jumpMan);
//		ImageGUI.getInstance().addImage(new Wall(new Point2D(2, 2)));
//
//	}

	public Room(){
		char[][] room = roomListMatrix.get(currentRoom);
		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < room[i].length; j++) {
				roomObjects(room[i][j], i, j);
			}
		}
		roomList.add(this);
	}

	//podemos depois multiplicar o numero da sala aos atributos de alguns personagens
	public void roomObjects(char object, int i, int j){
		Point2D position = new Point2D(i, j);
		switch (object) {
			case 'W':
				ImageGUI.getInstance().addImage(new Wall(position));
				return;
			case 'H':
				jumpMan = new JumpMan(position, 100, 10);
				ImageGUI.getInstance().addImage(jumpMan);
				return;
			case 'G':
				ImageGUI.getInstance().addImage(new Kong(position, 100, 10));
				return;
			case 'S':
				//ImageGUI.getInstance().addImage(new Kong(position, 100, 10));
				return;

			case 'm':
				//ImageGUI.getInstance().addImage(new Kong(position, 100, 10));
				return;
			case '0':
				//ImageGUI.getInstance().addImage(new Kong(position, 100, 10));
				return;

			case 't':
				//ImageGUI.getInstance().addImage(new Kong(position, 100, 10));
				return;
			case ' ':
				//ImageGUI.getInstance().addImage(new Kong(position, 100, 10));
				return;
						}


	}


	public static char[][] createMatrix(File file) throws FileNotFoundException{
		char[][] matrix = new char[10][10];
		Scanner sc = new Scanner(file);
		config.add(sc.nextLine());

		int i = 0;
		while (sc.hasNextLine() && i < matrix.length) {
				String line = sc.nextLine();
				for (int j = 0; j < matrix[i].length; j++) {
					matrix[j][i] = line.charAt(j);  //j e i invertidos porque sim?
				}
				i++;
		}
		return matrix;
	}


	public void moveManel(int k) {
		jumpMan.move(Direction.directionFor(k));
	}

	public static void changeRoom(int newRoomIndex) {
		if (newRoomIndex >= 0 && newRoomIndex < roomListMatrix.size()) {
			currentRoom = newRoomIndex;
			new Room();
		} else {
			throw new IllegalArgumentException("Índice de sala inválido!");
		}
	}

//	public static void main(String[] args) {
//    // Print the number of columns of each line in the files in the rooms directory
//    System.out.println("0");
//    File[] files = new File("rooms").listFiles();
//    if (files == null) {
//        System.out.println("No files found in the 'rooms' directory.");
//        return;
//    }
//    System.out.println("1");
//    for (File file : files) {
//        try (Scanner sc = new Scanner(file)) {
//            System.out.println("File: " + file.getName());
//            int lineNumber = 1;
//            while (sc.hasNextLine()) {
//                String line = sc.nextLine();
//                int columns = line.length();
//                System.out.println("Line " + lineNumber + " Columns: " + columns);
//                lineNumber++;
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found: " + file.getName());
//            e.printStackTrace();
//        }
//    }
//}
	
}