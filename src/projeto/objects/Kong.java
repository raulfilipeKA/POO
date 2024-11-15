package projeto.objects;

import projeto.pt.iscte.poo.utils.Direction;
import projeto.pt.iscte.poo.utils.Point2D;

public class Kong extends Character {
    private static final int HP = 100;
    private static final int ATK = 10;

    public Kong(Point2D initialPosition, int health, int attack) {
        //podemos multiplicar o numero da sala aos atributos de alguns personagens
        super(initialPosition, health, attack);
    }

    @Override
    public String getName() {
        return "DonkeyKong";
    }

    public void move() {
        //if level is <4, move randomly
        this.position = getPosition().plus(Direction.random().asVector());

        //position = position.plus(Direction.random().asVector());
    }
}
