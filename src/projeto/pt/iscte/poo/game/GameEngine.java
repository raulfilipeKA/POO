package projeto.pt.iscte.poo.game;

import projeto.pt.iscte.poo.gui.ImageGUI;
import projeto.pt.iscte.poo.observer.Observed;
import projeto.pt.iscte.poo.observer.Observer;
import projeto.pt.iscte.poo.utils.Direction;

public class GameEngine implements Observer {

	private Room currentRoom = new Room();
	private int lastTickProcessed = 0;

	public GameEngine() {
		ImageGUI.getInstance().update();
	}

	@Override
	public void update(Observed source) {

		if (ImageGUI.getInstance().wasKeyPressed()) {
			int k = ImageGUI.getInstance().keyPressed();
			System.out.println("Keypressed " + k);
			if (Direction.isDirection(k)) {
				System.out.println("Direction! ");
				currentRoom.moveManel(k);
			}
		}
		int t = ImageGUI.getInstance().getTicks();
		while (lastTickProcessed < t) {
			processTick();
		}
		ImageGUI.getInstance().update();
	}

	private void processTick() {
		System.out.println("Tic Tac : " + lastTickProcessed);
		lastTickProcessed++;
	}



}
