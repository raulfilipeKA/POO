package projeto.objects;

import projeto.pt.iscte.poo.utils.Direction;
import projeto.pt.iscte.poo.utils.Point2D;


public class Banana extends Projectile {
    private static final int DAMAGE = 10;

    public Banana(Point2D position) {
        super(position, DAMAGE);
    }

    @Override
    public String getName() {
        return "Banana";
    }


    public void move() {setPosition(getPosition().plus(Direction.DOWN.asVector()));}


}
