package projeto.pt.iscte.poo.game;

import projeto.objects.Manel;
import projeto.objects.Wall;
import projeto.pt.iscte.poo.gui.ImageGUI;
import projeto.pt.iscte.poo.utils.Point2D;

public class Room {
	
	private Point2D heroStartingPosition = new Point2D(1, 1);
	private Manel manel;
	
	public Room() {
		manel = new Manel(heroStartingPosition);
		ImageGUI.getInstance().addImage(manel);
		ImageGUI.getInstance().addImage(new Wall());

	}

	public void moveManel() {
		manel.move();
	}
	
}