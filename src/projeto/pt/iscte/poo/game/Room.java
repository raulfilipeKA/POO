package projeto.pt.iscte.poo.game;

import projeto.objects.JumpMan;
import projeto.objects.Wall;
import projeto.pt.iscte.poo.gui.ImageGUI;
import projeto.pt.iscte.poo.utils.Direction;
import projeto.pt.iscte.poo.utils.Point2D;

public class Room {
	
	private Point2D heroStartingPosition = new Point2D(1, 1);
	private JumpMan jumpMan;
	
	public Room() {
		jumpMan = new JumpMan(heroStartingPosition, 100, 10);
		ImageGUI.getInstance().addImage(jumpMan);
		ImageGUI.getInstance().addImage(new Wall(new Point2D(2, 2)));

	}

	public void moveManel(int k) {
		jumpMan.move(Direction.directionFor(k));
	}
	
}