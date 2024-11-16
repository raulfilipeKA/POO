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

//	@Override
//	public void createImage(GameObject object) {
//		ImageGUI.getInstance().addImage(object);
//	}

	@Override
	public void createImage(){
		ImageGUI.getInstance().addImage(this);
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
		if (isValidMove(position.plus(direction.asVector()))) {
			position = position.plus(direction.asVector());
		}
		if(!isValidMove(position.plus(direction.asVector()))){
			//verificar se a posicao é de um inimigo ou de um obstaculo (podemos colocar todos na mesma layer)
			//se for de um inimigo, ele ataca
			//no codigo do inimigo, o jumpman é atacado
			//se for um item ele apanha
			//se for um obstaculo ele nao se move
			//super.getObjects()
		}
	}

}
