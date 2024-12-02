package projeto.objects;

import projeto.pt.iscte.poo.game.Gravity;
import projeto.pt.iscte.poo.gui.ImageGUI;
import projeto.pt.iscte.poo.utils.Direction;
import projeto.pt.iscte.poo.utils.Point2D;

public class JumpMan extends Character implements Gravity {
	private static int ATTACK = 10;
	private static int HEALTH = 100;
	private int lives = 3;
	private boolean hasKey;
	private int wayIsFacing;

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

	public void move(Direction direction) {
		setPosition(getPosition().plus(direction.asVector()));
	}

	public void keyState(boolean state) {this.hasKey = state;}

	public boolean hasKey() {return this.hasKey;}

	@Override
	public void applyGravity() {this.move(Direction.DOWN);}

	public void deployBomb(){new Bomb(this);}

	public int getLives() {return this.lives;}

	public void setWayIsFacing(int wayIsFacing) {this.wayIsFacing = wayIsFacing;}
	public int getWayIsFacing() {return this.wayIsFacing;}


}
