package projeto.pt.iscte.poo.game;

import projeto.pt.iscte.poo.gui.ImageGUI;
import projeto.pt.iscte.poo.observer.*;
import projeto.pt.iscte.poo.utils.Direction;

import java.io.FileNotFoundException;

public class GameEngine implements Observer {
	private int room=1;
	private Room currentRoom;
	private int lastTickProcessed = 0;

	public GameEngine() throws FileNotFoundException {
		currentRoom = new Room(room);
		ImageGUI.getInstance().update();
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
		if(isEven(lastTickProcessed)) {currentRoom.moveKong();}

		while (lastTickProcessed < t) {
			processTick();
		}
		ImageGUI.getInstance().update();
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

	public static boolean isEven(int n) {
		return n % 2 == 0;
	}

}
