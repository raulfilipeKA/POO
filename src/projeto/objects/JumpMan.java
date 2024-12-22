package projeto.objects;

import projeto.pt.iscte.poo.utils.Direction;
import projeto.pt.iscte.poo.utils.Point2D;

import java.util.ArrayList;

public class JumpMan extends Character {
	public static final int ATTACK = 10;
	public static final int HEALTH = 100;
	private int lives = 3;
	private boolean hasKey;

	public JumpMan(Point2D initialPosition) {
		super(initialPosition, HEALTH, ATTACK);
	}

	@Override
	public String getName() {return "JumpMan";}

	public void move(Direction direction) {setPosition(getPosition().plus(direction.asVector()));}

	public void setHasKey(boolean state) {this.hasKey = state;}

	public boolean hasKey() {return this.hasKey;}


	public int getLives() {return this.lives;}

	public void loseLife() {this.lives--;}

	@Override
	public boolean canTeleport() {return true;}

	@Override
	public boolean canCatchItem(){return true;}


}
