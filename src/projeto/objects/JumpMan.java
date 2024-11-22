package projeto.objects;

import projeto.pt.iscte.poo.gui.ImageGUI;
import projeto.pt.iscte.poo.utils.*;

public class JumpMan extends Character {
	private static int ATTACK = 10;
	private static int HEALTH = 100;

	public JumpMan(Point2D initialPosition) {
		super(initialPosition, HEALTH, ATTACK);
		this.createImage();
	}

	@Override
	public void createImage(){
		ImageGUI.getInstance().addImage(this);
	}

	@Override
	public String getName() {
		return "JumpMan";
	}


//	@Override
//	public int getLayer() {
//		return 1;
//	}

	public void move(Direction direction) {
		setPosition(getPosition().plus(direction.asVector()));
	}

}
