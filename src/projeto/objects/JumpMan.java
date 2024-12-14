package projeto.objects;

import projeto.pt.iscte.poo.utils.Direction;
import projeto.pt.iscte.poo.utils.Point2D;

public class JumpMan extends Character {
	private static int ATTACK = 10;
	private static int HEALTH = 100;
	private int lives = 3;
	private boolean hasKey;

	public JumpMan(Point2D initialPosition) {
		super(initialPosition, HEALTH, ATTACK);
	}

	public JumpMan(Point2D inicialPosition, JumpMan jumpMan) {
		super(inicialPosition, jumpMan.getHealth(), jumpMan.getAttack());
		lives = jumpMan.getLives();
	}

	@Override
	public String getName() {return "JumpMan";}

	public void move(Direction direction) {
		setPosition(getPosition().plus(direction.asVector()));
	}

	public void setHasKey(boolean state) {this.hasKey = state;}

	public boolean hasKey() {return this.hasKey;}

	public void applyGravity() {this.move(Direction.DOWN);}

	public void deployBomb(){new Bomb(this);}

	public int getLives() {return this.lives;}

	public void loseLife() {this.lives--;}

	public void pickUp(Item item) {
		if (item != null && item.getPosition().equals(getPosition())) {
			if(item.getAttackBonus() > 0) {setAttack(getAttack() + item.getAttackBonus());}
			if(item.getHealthBonus() > 0) {setHealthBonus(getHealth()+item.getHealthBonus());}
		}
	}

	@Override
	public boolean canTeleport() {return true;}


}
