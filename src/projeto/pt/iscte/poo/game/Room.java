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

	private JumpMan jumpMan;
	private ArrayList<GameObject> roomObjectsList;
	private String doorConfig;
	private boolean needsKey = false;
	private boolean hasMeatToRot = false;
	private ArrayList<Character> characters = new ArrayList<>();
	private ArrayList<Projectile> projectiles = new ArrayList<>();


	public Room(int n) {
		try{
		roomObjectsList = new ArrayList<>();
		File[] files = new File("rooms").listFiles();
		char[][] room = readFile(files[n]);
		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < room[i].length; j++) {
				roomObjects(room[i][j], i, j, n);
			}
		}
		}catch (FileNotFoundException _) {
			System.out.println("Ficheiro não encontrado");
		}
		//roomList.add(this); todo meter no engine?
	}

	public Point2D getJumpManPosition() {
		return jumpMan.getPosition();
	}

	public ArrayList<GameObject> getRoomObjectsList() {
		return roomObjectsList;
	}

	public void deleteRoom() {
		for (GameObject object : roomObjectsList) {
			ImageGUI.getInstance().removeImage(object);
		}
		roomObjectsList.clear();}

	public void roomObjects(char object, int i, int j, int roomNumber){ //no fim apagar isto e passar cada simbolo para  cada objeto
		Point2D position = new Point2D(i, j);
		GameObject obj = null;
		//obj = new Floor(position);
		//roomObjectsList.add(new Floor(position));

		switch (object) {
			case 'W':
				obj = new Wall(position);
				roomObjectsList.add(obj);
				return;
			case 'H':
				roomObjectsList.add(new Floor(position));
				jumpMan = new JumpMan(position);
				return;
			case 'G':
				roomObjectsList.add(new Floor(position));
				obj = new Kong(position);
				characters.add((Character) obj);
				roomObjectsList.add(obj);
				return;
			case 'S':
				roomObjectsList.add(new Floor(position));
				obj = new Stairs(position);
				roomObjectsList.add(obj);
				return;
			case 'k':
				roomObjectsList.add(new Floor(position));
				obj = new Key(position);
				roomObjectsList.add(obj);
				needsKey = true;
				return;

			case 's':
				roomObjectsList.add(new Floor(position));
				obj = new Sword(position);
				roomObjectsList.add(obj);
				return;

			case 'm':
				roomObjectsList.add(new Floor(position));
				obj = new GoodMeat(position);
				roomObjectsList.add(obj);
				hasMeatToRot = true;
				return;
			case '0':
				roomObjectsList.add(new Floor(position));
				obj = new DoorClosed(position);
				roomObjectsList.add(obj);
				return;

			case 't':
				roomObjectsList.add(new Floor(position));
				obj = new Trap(position);
				roomObjectsList.add(obj);
				return;
			case ' ':
				roomObjectsList.add(new Floor(position));
				return;


		}

		if(obj instanceof Character){
			roomObjectsList.add(obj);
		}



	}

	public static void main(String[] args) {
		Room room = new Room(0);
		ArrayList<Character> objects = room.getCharacters();
		for (GameObject object : objects) {
			System.out.println(object.getName());
		}
	}

	public ArrayList<Character> getCharacters() {return characters;}

	public boolean hasMeatToRot() {return hasMeatToRot;}
	public boolean needsKey() {return needsKey;}


	public char[][] readFile(File file) throws FileNotFoundException{ //matriz para imagem em xy
		char[][] matrix = new char[10][10];
		Scanner sc = new Scanner(file);
		doorConfig=sc.nextLine();


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

	public void fall(GameObject object) {object.setPosition(object.getPosition().plus(Direction.DOWN.asVector()));}


	public void moveKong() {//if level is <4, move randomly
		Kong kong;
		Point2D p;
		for (GameObject possibleKong : roomObjectsList) {
			if(possibleKong instanceof Kong) {
				kong = (Kong) possibleKong;
				Point2D newPosition = kong.getPosition().plus(leftRight().asVector());
				System.out.println("\033[31m"+newPosition+"\033[0m");
				//if (isValidMove(p)){
				if (validMove(newPosition)){
					kong.move(newPosition);
					System.out.println(kong.getPosition());
					if(projectiles.size() < 7) {
						Banana banana = new Banana(new Point2D(kong.getPosition().getX(), kong.getPosition().getY() + 1));
						projectiles.add(banana);
					}

				}
			}
		}
	}


	public void applyGravity(){
		if(validMove(jumpMan.getPosition().plus(Direction.DOWN.asVector()))){
		jumpMan.applyGravity();}
	}

	public void moveProjectile(){
		for(Projectile projectile : projectiles){
				projectile.move();
				if (!withinBounds(projectile.getPosition())) {       // REVER ESTE CODIGO PARA VERIFICAR SE ESTA OUTOFBOUNDS
					deleteObject(projectile);
				}
				else if (whatsThere(projectile.getPosition()) instanceof Character) {
					Character character = (Character) whatsThere(projectile.getPosition());
					character.getsHit(projectile.getDamage());
					if (character.isDead()) {deleteObject(character);}
				}
		}
		System.out.println(projectiles.size());
	}

	private void deleteObject(GameObject object){
		object.removeImage();
		roomObjectsList.remove(object);
	}



	public void moveJumpMan(int k) {
		Direction d = Direction.directionFor(k);
		Point2D newPosition = jumpMan.getPosition().plus(d.asVector());
		if (isValidMove(newPosition) && whatsThere(newPosition) instanceof Item) {
			jumpMan.move(d);
			System.out.println("\033[33m" + jumpMan.getPosition() + "\033[0m");
			//jumpMan.pickUp(whatsThere(jumpMan.getPosition().plus(d.asVector())));
		} else if (isValidMove(newPosition) && whatsThere(newPosition) instanceof Item) {

			// todo jumpMan.pickUp(whatsThere(jumpMan.getPosition().plus(d.asVector())));
		} else if (whatsThere(newPosition) instanceof Character) {
			Character character = (Character) whatsThere(jumpMan.getPosition().plus(d.asVector()));
			jumpMan.attack(character);
			if (character.getHealth() <= 0) {
				roomObjectsList.remove(character);
			}
		} else if (isValidMove(newPosition)) {
			if (d.equals(Direction.UP)) {
				climb();
				return;
			} else
				jumpMan.move(d);
				System.out.println("\033[33m" + jumpMan.getPosition() + "\033[0m");
		}
	}

	public void climb(){
		ArrayList<GameObject> objects = whatsThereList(jumpMan.getPosition());
		for (GameObject object : objects) {
			if (object.isClimbable()) {
				jumpMan.move(Direction.UP);
			}
		}
	}

	public Direction leftRight(){return Math.random() < 0.5 ? Direction.LEFT : Direction.RIGHT;}


	public boolean withinBounds(Point2D position){
		return position.getX() >= 0 && position.getX() < 10 && position.getY() >= 0 && position.getY() < 10;
	}

	protected boolean validMove(Point2D newPosition){
		if(!withinBounds(newPosition)){return false;}
		ArrayList<GameObject> objects = whatsThereList(newPosition);
		for (GameObject object : objects) {
			if (!object.canGoThrough() || object instanceof Stairs) {
				return false;
			}
		}
		return true;

	}

	protected boolean isValidMove(Point2D newPosition){
		for(GameObject object : roomObjectsList){
			if(((object instanceof Wall || object instanceof Character || object instanceof Trap)
					&& object.getPosition().equals(newPosition))
			|| newPosition.getX() < 0 || newPosition.getX() >= 10
			|| newPosition.getY() < 0 || newPosition.getY() >= 10

			) {
				System.out.println("\033[32m"+object.getPosition()+"\033[0m");
				return false;}
		}
		return true;
	}

	public void rotMeat() {
		ArrayList<GoodMeat> meatsToRot = new ArrayList<>();
		for (GameObject object : roomObjectsList) {
			if (object instanceof GoodMeat) {
				meatsToRot.add((GoodMeat) object);
			}
		}
		for (GoodMeat goodMeat : meatsToRot) {
			BadMeat badMeat = new BadMeat(goodMeat.getPosition(), goodMeat.getHealthBonus());
			System.out.println("\u001B[32mMeat rotted\u001B[0m");
			roomObjectsList.remove(goodMeat);
			roomObjectsList.add(badMeat);
			System.out.println("\u001B[32mMeat rotted\u001B[0m");
		}
	}

	protected ArrayList<GameObject> whatsThereList(Point2D position) {
		ArrayList<GameObject> objects = new ArrayList<>();
		for (GameObject object : roomObjectsList) {
			if (object.getPosition().equals(position) && !(object instanceof Floor)) {
				objects.add(object);
			}
		}
		return objects;
	}

	protected GameObject whatsThere(Point2D position) {
		for (GameObject object : roomObjectsList) {
			if (object.getPosition().equals(position) &&
				//	!(object instanceof JumpMan) &&
					!(object instanceof Stairs) &&
					!(object instanceof Floor)) {
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
				roomObjectsList.remove(object);
				object.removeImage();
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

	public boolean atDoor2(){
		ArrayList<GameObject> objects = whatsThereList(jumpMan.getPosition());
		for (GameObject object : objects) {
			if (object instanceof DoorClosed) {
				System.out.println("\u001B[32mAt door\u001B[0m");
				System.out.println(needsKey);
				System.out.println("--------------------");
				for (GameObject object1 : roomObjectsList) {
					System.out.println(object1.getName());
				}
				return true;
			}
		}return false;
	}

//o metodo atDoor funciona
	public boolean atDoor1() {
	for (GameObject object : roomObjectsList) {
		if (object instanceof DoorClosed && object.getPosition().equals(jumpMan.getPosition())) {
			System.out.println("\u001B[32mAt door\u001B[0m");
			System.out.println(needsKey);
			System.out.println("--------------------");
			for (GameObject object1 : roomObjectsList) {
				System.out.println(object1.getName());

			}
			return true;
		}
	}
	return false;
}

	public void trocarPorta1(){
		if (((atDoor1() && !needsKey) || (atDoor1() && jumpMan.hasKey()))
				&& whatsThere(jumpMan.getPosition()) instanceof DoorClosed) {
			System.out.println("\u001B[32mChanging door\u001B[0m");
			ArrayList<GameObject> objects = whatsThereList(jumpMan.getPosition());
			for (GameObject object : objects) {
				if (object instanceof DoorClosed) {
					roomObjectsList.remove(object);
					roomObjectsList.add(new DoorOpen(object.getPosition()));
					object.removeImage();
					jumpMan.setHasKey(false);
				}
			}
		}
	}

	public boolean unlockDoor(){
		if (((atDoor1() && !needsKey) || (atDoor1() && jumpMan.hasKey()))
				&& whatsThere(jumpMan.getPosition()) instanceof DoorClosed) {
			ArrayList<GameObject> objects = whatsThereList(jumpMan.getPosition());
			for (GameObject object : objects) {
				if (object instanceof DoorClosed) {
					roomObjectsList.remove(object);
					object.removeImage();
					jumpMan.setHasKey(false);
					return true;
				}
			}
		}
		return false;
	}



	public void trocarPorta() {
		// verificar se o atributo do jumpma.haskey é valido validos
		if (jumpMan.hasKey() || !needsKey) {
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

	//NOVO
	public void catchItem() {
		for(GameObject object : roomObjectsList) {
			if (object instanceof Item && object.getPosition().equals(jumpMan.getPosition())) {
				Item item = (Item) object;
				jumpMan.pickUp(item);
				roomObjectsList.remove(object);
				object.removeImage();
				return;
			}
		}
	}

//	//NOVO
//	public void moveBat() {//if level is <4, move randomly
//		Bat bat;
//		Point2D p;
//		for (GameObject possibleKong : roomObjectsList) {
//			if(possibleKong instanceof Kong) {
//				bat = (BAt) possibleKong;
//				p = bat.getPosition().plus(Direction.random().asVector());
//				System.out.println("\033[31m"+p+"\033[0m");
//				if (isValidMove(p)){
//					bat.move(p);
//					System.out.println(kong.getPosition());
//					kong.deployProjectile(new Banana(p));
//				} else{return;}
//			}
//		}
//	}

}