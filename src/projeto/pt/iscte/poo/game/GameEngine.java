package projeto.pt.iscte.poo.game;

import projeto.pt.iscte.poo.gui.ImageGUI;
import projeto.pt.iscte.poo.observer.*;
import projeto.pt.iscte.poo.utils.Direction;
import java.io.File;
//import java.util.ArrayList;

public class GameEngine implements Observer {
	private int roomNum=0;  // todo static?
	private Room currentRoom;
	private int lastTickProcessed = 0;
	//private static ArrayList<Room> roomList = new ArrayList<>(); // todo static ?

	public GameEngine()  {
		//posso criar logo as salas todas ?
		// fica tudo sobreposto com o getInstance().update
		currentRoom = new Room(roomNum);
		ImageGUI.getInstance().update();
	}
//com os valores a static nao deve dar para fazer upadate
//	public static void changeRoom(int newRoomIndex) {
//		if (newRoomIndex >= 0 && newRoomIndex < roomList.size()) {
//			roomNum = newRoomIndex;
//			new Room(roomNum);
//		} else {
//			throw new IllegalArgumentException("Índice de sala inválido!");
//		}
//	}

	public void changeRoom(int newRoomIndex) {
		if (newRoomIndex >= 0 && newRoomIndex < numberOfRoomFiles()) {
			new Room(newRoomIndex);
			//alterar o numero da sala
			roomNum = newRoomIndex;
		} else {
			throw new IllegalArgumentException("Índice de sala inválido!");
		}
	}

	public static int numberOfRoomFiles() {
		return new File("rooms").listFiles().length;
	}

	@Override
	public void update(Observed source) {

		if (ImageGUI.getInstance().wasKeyPressed()) {
			int k = ImageGUI.getInstance().keyPressed();
			System.out.println("Keypressed " + k);
			if (Direction.isDirection(k)) {
				System.out.println("Direction! ");
				currentRoom.moveJumpMan(k);
			}
		}
		int t = ImageGUI.getInstance().getTicks();
		//inserir o movimento do kong
		//a funcao ja faz update sozinha entao nao podemos fazer
		//loops aqui
		if(isEven(lastTickProcessed)) {
			currentRoom.moveKong();}

		while (lastTickProcessed < t) {
			processTick();
		}
		ImageGUI.getInstance().update();
		 // Testar coleta de chave
        currentRoom.catchKey();
        System.out.println("JumpMan tem a chave? " + currentRoom.getJumpMan());

        // Testar troca de porta
        currentRoom.trocarPorta();
        System.out.println("Porta aberta? " + currentRoom.isFinished());
	}

	private boolean gameFinished() {
		//if(manel.getposition() == portaAberta) || manelIsDead()) {
			//inserir logica
		//}
		return false;
	}

	private void processTick() {
		System.out.println("Tic Tac : " + lastTickProcessed);
		lastTickProcessed++;
	}

//	private int roomListSize() {
//		return roomList.size();
//	}

	public static boolean isEven(int n) {
		return n % 2 == 0;
	}

}
