package projeto.objects;

import projeto.pt.iscte.poo.gui.ImageTile;
import projeto.pt.iscte.poo.utils.Point2D;

public class Floor implements ImageTile {

	public Floor() {
	}

	@Override
	public String getName() {
		return "Floor";
	}

	@Override
	public int getLayer() {
		return 0;
	}

	@Override
	public Point2D getPosition() {
		// TODO Auto-generated method stub
		return null;
	}


}
