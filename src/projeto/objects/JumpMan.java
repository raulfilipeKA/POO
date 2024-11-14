package projeto.objects;

import projeto.pt.iscte.poo.utils.Direction;
import projeto.pt.iscte.poo.utils.Point2D;

public class JumpMan extends Character {

	public JumpMan(Point2D initialPosition, int health, int attack) {
		super(initialPosition, health, attack);
	}

	@Override
	public String getName() {
		return "JumpMan";
	}

//	@Override
//	public Point2D getPosition() {
//		return position;
//	}

//	@Override
//	public int getLayer() {
//		return 1;
//	}

	public void move(Direction direction) {
		this.position = position.plus(direction.asVector());
	}

}
