package projeto.objects;

import projeto.pt.iscte.poo.utils.Direction;
import projeto.pt.iscte.poo.utils.Point2D;


public class Banana extends Projectile {
    private static final int DAMAGE = 10;

    public Banana(Point2D position) {
        super(position, DAMAGE);
        this.applyGravity();
    }



    public void trajectory(Direction direction) {
        applyGravity();
    }

    @Override
    public String getName() {
        return "Banana";
    }

    @Override
    public int getLayer() {
        return 0;
    }

    public void applyGravity() {
        setPosition(getPosition().plus(Direction.DOWN.asVector()));
        if(getPosition().getY() == 9) {
            removeImage();
        }
    }
}
