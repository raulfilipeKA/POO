package projeto.pt.iscte.poo.game;

import projeto.pt.iscte.poo.gui.ImageGUI;
import projeto.pt.iscte.poo.observer.Observed;
import projeto.pt.iscte.poo.observer.Observer;
import projeto.pt.iscte.poo.utils.Direction;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class GameEngine implements Observer {
	private int roomNum=0;
	private Room currentRoom;
	private int lastTickProcessed = 0;
	private int ticksProcessedInCurrentRoom = 0;
	private boolean gameIsFinished = false;

	public GameEngine()  {
		currentRoom = new Room(roomNum);
		ImageGUI.getInstance().update();
	}


	public void changeRoom(int newRoomIndex) {
		if (newRoomIndex >= 0 && newRoomIndex < numberOfRoomFiles()) {
			System.out.println(currentRoom.getJumpMan().getAttack());
			currentRoom.deleteRoom();
			roomNum = newRoomIndex;
			currentRoom = new Room(roomNum);
			System.out.println(currentRoom.getJumpMan().getAttack());
			//totalTicksProcessed+=lastTickProcessed;
			ticksProcessedInCurrentRoom = 0;
		} else {
			throw new IllegalArgumentException("Índice de sala inválido!");
		}
	}

	public static int numberOfRoomFiles() {return new File("rooms").listFiles().length;}

	@Override
	public void update(Observed source) {
		//a funcao ja faz update sozinha entao nao podemos fazer loops aqui

		if (ImageGUI.getInstance().wasKeyPressed()) {
			int k = ImageGUI.getInstance().keyPressed();
			System.out.println("Keypressed " + k);
			if (Direction.isDirection(k)) {
				System.out.println("Direction! ");
				currentRoom.moveJumpMan(k);
			}
			if (k == 98 || k == 66) {
				currentRoom.getJumpMan().deployBomb();
			}
		} else{
			currentRoom.applyGravity();
		}
		int t = ImageGUI.getInstance().getTicks();

		  System.out.println("T: " + t);

		if (isEven(lastTickProcessed)) {currentRoom.moveKong();}

		if (ticksProcessedInCurrentRoom == 15 && currentRoom.hasMeatToRot()) {currentRoom.rotMeat();}

		if(lastTickProcessed<t){
			processTick();
		}

		if(isEven(lastTickProcessed)){currentRoom.moveProjectile();}

//		while (lastTickProcessed < t) {
//			processTick();
//		}
		//if(isEven(lastTickProcessed)){		currentRoom.applyGravity();}

		ImageGUI.getInstance().update();
		// Testar coleta de chave
		currentRoom.catchKey();
		System.out.println("JumpMan tem a chave? " + currentRoom.getJumpMan().hasKey());
		System.out.println("Porta precisa de chave? " + currentRoom.needsKey());

		if (currentRoom.atDoor1() &&
				(currentRoom.getJumpMan().hasKey() || !currentRoom.needsKey())) {
			//currentRoom.trocarPorta1(); como change room é mais lento, ele executa esta acao tres vezes
			changeRoom(roomNum + 1);
			lastTickProcessed = 0;
			//ImageGUI.getInstance().update();

		}

//		if (currentRoom.unlockDoor()) {
//			changeRoom(roomNum + 1);
//
//		}
		if(isGameFinished()){
			System.out.println("Game is finished! Score: " + lastTickProcessed);
			System.out.println("Updating leaderboards...");
			updateLeaderboards();
			criarFicheiro();
		}
	}

	public void updateLeaderboards() {
		//inserir logica para guardar score
	}

	private void processTick() {
		System.out.println("Tic Tac : " + lastTickProcessed);
		lastTickProcessed++;
		ticksProcessedInCurrentRoom++;}


	public static boolean isEven(int n) {return n % 2 == 0;}

	public boolean isGameFinished() {
		if(roomNum == numberOfRoomFiles()-1 && currentRoom.atDoor1()
				&& (currentRoom.getJumpMan().hasKey() || !currentRoom.needsKey())) {
			return true;
			//gameIsFinished = true;
		}
		return false;
		//return gameIsFinished;
	}





//    public void explode() {
//        for (int i = -EXPLOSION_RADIUS; i <= EXPLOSION_RADIUS; i++) {
//            for (int j = -EXPLOSION_RADIUS; j <= EXPLOSION_RADIUS; j++) {
//                Point2D position = new Point2D(getPosition().getX() + i, getPosition().getY() + j);
//                if (position.equals(getPosition())) {
//                    GameObject gameObject = whatsThere(position); // ver o metodo e aplicar
//                    if (gameObject.isDestructible()) {
//                        ga*meObject.dispose();
//                    }
//                }
//            }
//        }
//	removeImage();
//}

	//NOVO
	public void wait(int nTicks) {
		int tickFinal = lastTickProcessed + nTicks;
		while(lastTickProcessed <= tickFinal) {
			processTick();
			ImageGUI.getInstance().update();
		}
	}

	//NOVO
	private ArrayList<Integer> leaderBoard = new ArrayList<>();

	//NOVO
	public void atualizarLeaderBoard() {
		int tempoAtual = lastTickProcessed;
		if (leaderBoard.size() < 10) {
			leaderBoard.add(tempoAtual);
		} else {
			for (int i = 0; i < leaderBoard.size(); i++) {
				if (tempoAtual < leaderBoard.get(i)) {
					leaderBoard.remove(i);
					leaderBoard.add(tempoAtual);
					break;
				}
			}
		}

		Collections.sort(leaderBoard, Collections.reverseOrder());
	}

	//NOVO
	public void criarFicheiro() {
		try(PrintWriter fileWriter = new PrintWriter(("leaderBoard.txt"))) {
			for(Integer tempo : leaderBoard) {
				fileWriter.println(tempo);
			}
			fileWriter.close();
		} catch (FileNotFoundException _) {
			System.err.println("Erro na criação do ficheiro");
		}
	}

}
