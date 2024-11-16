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
		if (isValidMove(position.plus(direction.asVector()))) {
			this.position = position.plus(direction.asVector());
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
