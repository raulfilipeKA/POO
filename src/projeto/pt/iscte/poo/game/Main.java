package projeto.pt.iscte.poo.game;

import projeto.pt.iscte.poo.gui.ImageGUI;

public class Main {

	public static void main(String[] args) {
		ImageGUI gui = ImageGUI.getInstance();
		GameEngine engine = new GameEngine();
		gui.setStatusMessage("Good luck!");
		gui.registerObserver(engine);
		gui.go();
	}
	
}