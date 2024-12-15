package projeto.objects;

import projeto.pt.iscte.poo.utils.Direction;
import projeto.pt.iscte.poo.utils.Point2D;

public class Bat extends Character {

    public Bat(Point2D position, int health, int damage) {
        super(position, health, damage);
    }

    @Override
    public String getName() {return "Bat";}

    public void move(Point2D position) {
        Direction dir = getPosition().directionTo(position);
        setPosition(getPosition().plus(dir.asVector()));
    }

    public void move(Direction d){setPosition(getPosition().plus(d.asVector()));}

}
