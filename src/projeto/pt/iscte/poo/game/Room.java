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

import static projeto.objects.Bomb.EXPLOSION_RADIUS;

public class Room {

	private JumpMan jumpMan;
	private Door door;
	private Point2D jumpManInitialPosition;
	private ArrayList<GameObject> roomObjectsList;
	private String doorConfig;
	private boolean needsKey = false;
	private boolean hasMeatToRot = false;
	private ArrayList<Character> characters = new ArrayList<>();
	private ArrayList<Projectile> projectiles = new ArrayList<>();
	private ArrayList<Bomb> bombs = new ArrayList<>();
	private boolean lastRoom=false;
	//WARNING: o jumpMan nao esta a ser adicionado à lista de objetos da sala

	public Room(int n, JumpMan jumpMan) {
		setupRoom(n, jumpMan);
		ImageGUI.getInstance().update();
	}

	public Room() {
		setupRoom(0, null);
		ImageGUI.getInstance().update();
	}


	public void setupRoom(int n, JumpMan jumpMan) {
		roomObjectsList = new ArrayList<>();
		try {
			char[][] matrix = readFile(new File("rooms/room" + n + ".txt"));
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					roomObjects(matrix[i][j], i, j, n, jumpMan);
				}
			}
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Ficheiro não encontrado");
		}
	}

	public ArrayList<GameObject> getRoomObjectsList() {return roomObjectsList;}

	public void deleteRoom() {
		for (GameObject object : roomObjectsList) {
			ImageGUI.getInstance().removeImage(object);
		}
		for (Projectile projectile : projectiles) {
			projectile.removeImage();
		}
		ImageGUI.getInstance().removeImage(jumpMan);
		roomObjectsList.clear();
		characters.clear();
		projectiles.clear();
	}

	public void roomObjects(char object, int i, int j, int roomNumber, JumpMan jumpMan) {
		Point2D position = new Point2D(i, j);
		GameObject obj;
		//obj = new Floor(position);
		//roomObjectsList.add(new Floor(position));

		switch (object) {
			case 'W':
				obj = new Wall(position);
				roomObjectsList.add(obj);
				return;
			case 'H':
				roomObjectsList.add(new Floor(position));
				if (roomNumber == 0 || jumpMan == null) {
					this.jumpMan = new JumpMan(position);
				} else {
					this.jumpMan = jumpMan;
					this.jumpMan.teleport(position);
				}
				jumpManInitialPosition = position;
				return;
			case 'P':
				roomObjectsList.add(new Floor(position));
				roomObjectsList.add(new Princess(position));
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
				door = (Door) obj;
				door.setRoomDets(doorConfig);
				roomObjectsList.add(obj);
				return;
			case 'B':
				roomObjectsList.add(new Floor(position));
				obj = new Bat(position);
				roomObjectsList.add(obj);
				characters.add((Character) obj);
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
	}

	public Door getDoor() {
		if(door == null){lastRoom = true;}
		return door;
	}

	public ArrayList<Character> getCharacters() {return characters;}

	public boolean hasMeatToRot() {return hasMeatToRot;}

	public boolean needsKey() {return needsKey;}


	public char[][] readFile(File file) throws FileNotFoundException { //matriz para imagem em xy
		char[][] matrix = new char[10][10];
		Scanner sc = new Scanner(file);
		doorConfig = sc.nextLine();

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


	public void fall(GameObject object) {
		object.setPosition(object.getPosition().plus(Direction.DOWN.asVector()));
	}

	//NOVO
	public void moveBat() {
		Bat bat;
		Point2D newPosition;
		for (Character possibleBat : characters) {
			if(possibleBat instanceof Bat) {
				bat = (Bat) possibleBat;
				newPosition = bat.getPosition().plus(Direction.DOWN.asVector());
				if(isValidMoveBat(newPosition) && checkForStairs(newPosition)) {  //implementar a gravidade para caso nao ter nado em baixo o morcego cair
					bat.move(newPosition);
					if (bat.getPosition().equals(jumpMan.getPosition())) {
						jumpMan.getsHit(bat.getAttack());
						deleteObject(bat);
						return;
					}
				} else {
					newPosition = bat.getPosition().plus(leftRight().asVector());
					if (isValidMoveBat(newPosition)){
						bat.move(newPosition);
						if(newPosition.equals(jumpMan.getPosition())){
							jumpMan.getsHit(bat.getAttack());
							deleteObject(bat);
							return;
						}
					}
				}
			}
		}
	}

	public void moveKong() {
		Kong kong;
		for (GameObject possibleKong : roomObjectsList) {

			if (possibleKong instanceof Kong) {
				kong = (Kong) possibleKong;
				Point2D newPosition = kong.getPosition().plus(leftRight().asVector());
				if (projectiles.size() < 7 * characters.size()) {
					Banana banana = new Banana(new Point2D(kong.getPosition().getX(), kong.getPosition().getY() + 1));
					projectiles.add(banana);
				}
				if (newPosition.equals(jumpMan.getPosition())) {
					jumpMan.getsHit(kong.getAttack());
					System.out.println("\033[34mVida" + jumpMan.getHealth() + "\033[0m");
				} else if (isValidMove(newPosition)) {
					kong.move(newPosition);
					if(whatsThere(newPosition, Bomb.class)!= null){
						Bomb bomb = whatsThere(newPosition, Bomb.class);
						detonateBomb(bomb);
						bomb.removeImage();
					}
				}
			}
		}
	}


	public void applyGravity() {  //podiamos acrescentar os outros metodos de gravidade inclusive para os projeteis
		if (validToFall(jumpMan.getPosition().plus(Direction.DOWN.asVector()))) {
			jumpMan.fall();
		}
		for (GameObject object : roomObjectsList) {
			if (object.canApplyGravity() && validToFall(object.getPosition().plus(Direction.DOWN.asVector()))) {
				object.fall();
			}
		}
	}

	protected boolean isValidMoveBat(Point2D newPosition){
		for(GameObject object : roomObjectsList){
			if(((object instanceof Wall || object instanceof Trap || object instanceof WallTrap)
					&& object.getPosition().equals(newPosition))
					|| newPosition.getX() < 0 || newPosition.getX() >= 10
					|| newPosition.getY() < 0 || newPosition.getY() >= 10

			) {
				System.out.println("\033[32m"+object.getPosition()+"\033[0m");
				return false;}
		}
		return true;
	}


	public void moveProjectile() {
		for (Projectile projectile : projectiles) {

			projectile.move();
			if (outOfBounds(projectile.getPosition())) {
				projectile.setOutOfBounds(true);
				projectile.removeImage();
			}
			//podia implementar para ver se atinge Characters caso o JumpMan venha a lançar projeteis tambem
			else if (projectile.getPosition().equals(jumpMan.getPosition())) {
				projectile.hit(true);

				jumpMan.getsHit(projectile.getDamage());
				projectile.removeImage();
			}
		}
		projectiles.removeIf(projectile -> projectile.getOutOfBounds());
		projectiles.removeIf(projectile -> projectile.getHit());
	}


	public void moveJumpMan(int k) {
		Direction d = Direction.directionFor(k);
		Point2D newPosition = jumpMan.getPosition().plus(d.asVector());
		if (isValidMove(newPosition) && whatsThere(newPosition) instanceof Item) {
			jumpMan.move(d);
			System.out.println("\033[33m" + jumpMan.getPosition() + "\033[0m");
			Item item = whatsThere(newPosition, Item.class);  //todo acho q fiz magia
			jumpMan.catchItem(whatsThere(newPosition, Item.class));
			deleteObject(item);
		} else if (whatsThere(newPosition) instanceof Character) {
			Character character = (Character) whatsThere(jumpMan.getPosition().plus(d.asVector()));
			jumpMan.attack(character);
			if (character.getHealth() <= 0) {
				deleteObject(character);
			}

		} else if (isValidMove(newPosition)) {
			if(whatsThere(newPosition, Bomb.class)!= null){
				Bomb bomb = whatsThere(newPosition, Bomb.class);
				bomb.destroy();
				detonateBomb(bomb);
				bomb.removeImage();
			}
			if (d.equals(Direction.UP)) {
				climb();
				return;
			} else {
				jumpMan.move(d);
				System.out.println("\033[33m" + jumpMan.getPosition() + "\033[0m");
			}
		}
	}


	public void climb() {
		ArrayList<GameObject> objects = whatsThereList(jumpMan.getPosition());
		for (GameObject object : objects) {
			if (object.isClimbable()) {
				jumpMan.move(Direction.UP);
			}
		}
	}

	public void checkTrap(){
		if (jumpMan.getPosition().getY() != 9) {
			Point2D positionBelow = new Point2D(jumpMan.getPosition().getX(), jumpMan.getPosition().getY() + 1);
			Trap trap = whatsThere(positionBelow, Trap.class);
			if (trap != null) {trap.trapJumpMan(jumpMan);}
			System.out.println("TRAP"+jumpMan.getHealth());
		}
	}

	public void deployBomb(int time) {
		Bomb bomb = new Bomb(jumpMan, time);
		bombs.add(bomb);
		roomObjectsList.add(bomb);
	}

	public void checkForDetonation(int time) {
		ArrayList<Bomb> arr = new ArrayList<>(bombs);
		for (Bomb bomb : arr) {
			if (bomb.getBlowAt() == time) {
				bomb.blow();
				detonateBomb(bomb);
				bomb.removeImage();
			} bombs.removeIf(Bomb::isBlown);
		}

	}

	public void removeDestroyedObjects() {
		ArrayList<GameObject> arr = new ArrayList<>(roomObjectsList);
		for(GameObject object : arr){
			if(object.isDestroyed()){
				deleteObject(object);
			}
		}
	}


	public void detonateBomb(Bomb bomb){
		bomb.destroy();
		for (int i = -EXPLOSION_RADIUS; i <= EXPLOSION_RADIUS; i++) {
			for (int j = -EXPLOSION_RADIUS; j <= EXPLOSION_RADIUS; j++) {
				Point2D position = new Point2D(bomb.getPosition().getX() + i, bomb.getPosition().getY() + j);
				ArrayList<GameObject> gameObjects = whatsThereList(position);
				for (GameObject gameObject : gameObjects) {
					if(gameObject instanceof Character){
						Character character = (Character) gameObject;
						character.getsHit(bomb.getDamage());
					}
					if (gameObject.isDestroyable()) {gameObject.destroy();}
				}
				if(position.equals(jumpMan.getPosition())){
					jumpMan.getsHit(bomb.getDamage());
				}
			}
		}
		removeDestroyedObjects();
	}

	public Direction leftRight(){return Math.random() < 0.5 ? Direction.LEFT : Direction.RIGHT;}


	public boolean outOfBounds(Point2D position){
		return position.getX() < 0 || position.getX() >= 10 || position.getY() < 0 || position.getY() >= 10;
	}

	protected boolean validToFall(Point2D newPosition){  //util para a gravidade
		if(outOfBounds(newPosition)){return false;}
		ArrayList<GameObject> objects = whatsThereList(newPosition);
		for (GameObject object : objects) {
			if (!object.canGoThrough() || object instanceof Stairs) {
				return false;
			}
		}
		return true;

	}


	private void deleteObject(GameObject object) {
		if (object instanceof Projectile) {
			projectiles.remove(object);
		}
		if (object instanceof Character) {
			characters.remove(object);
		}

		roomObjectsList.remove(object);
		object.removeImage();
	}

	protected boolean isValidMove(Point2D newPosition){
		for(GameObject object : roomObjectsList){
			if((!object.canGoThrough()
					&& object.getPosition().equals(newPosition))
					|| outOfBounds(newPosition))
			{return false;}
		}
		return true;
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

	protected GameObject whatsThere(Point2D position) {  //retorna um objeto que nao seja parede nem porta nem escadas
		for (GameObject object : roomObjectsList) {
			if (object.getPosition().equals(position) &&
				//	!(object instanceof JumpMan) &&
					!(object instanceof Stairs) &&
					!(object instanceof Door) &&
					!(object instanceof Floor)) {
				return object;
			}
		}
		return null;
	}
	public boolean checkForStairs(Point2D point2d) {
		Stairs stairs= whatsThere(point2d, Stairs.class);
		//		for(GameObject object : objects) {
		//			if(object instanceof Stairs) {return true;}
		//		}
		//		System.err.println("NAO FOI ENCONTRADo");
		return stairs != null;
	}

	public <T> T whatsThere(Point2D position, Class<T> type) {  //todo ver se funciona  FIZ MAGIA
		for (GameObject object : roomObjectsList) {
			if (type.isInstance(object) && object.getPosition().equals(position)) {
				return type.cast(object);
			}
		}
		return null;
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

	public void rotMeat() {
		ArrayList<GoodMeat> meatsToRot = new ArrayList<>();
		for (GameObject object : roomObjectsList) {
			if (object instanceof GoodMeat) {meatsToRot.add((GoodMeat) object);}
		}
		for (GoodMeat goodMeat : meatsToRot) {
			BadMeat badMeat = new BadMeat(goodMeat.getPosition(), goodMeat.getHealthBonus());
			deleteObject(goodMeat);
			roomObjectsList.add(badMeat);
			System.out.println("\u001B[32mMeat rotted\u001B[0m");
		}
	}

	public boolean atDoor() {
	for (GameObject object : roomObjectsList) {
		if (object instanceof DoorClosed && object.getPosition().equals(jumpMan.getPosition())) {
			System.out.println("\u001B[32mAt door\u001B[0m");
			System.out.println(needsKey);
			System.out.println("--------------------");
			return true;
		}
	}
	return false;
}


	public Point2D getJumpManInitialPosition() {return jumpManInitialPosition;}
	public JumpMan getJumpMan() {return jumpMan;}





}