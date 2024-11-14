package projeto.objects;

import projeto.pt.iscte.poo.utils.Direction;
import projeto.pt.iscte.poo.utils.Point2D;

public class Kong extends Character {

    public Kong(Point2D initialPosition, int health, int attack) {
        super(initialPosition, health, attack);
    }

    @Override
    public String getName() {
        return "Kong";
    }

    public void move() {
        //if level is <4, move randomly
        this.position = getPosition().plus(Direction.random().asVector());

        //position = position.plus(Direction.random().asVector());
    }
}
