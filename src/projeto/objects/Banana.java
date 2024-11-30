package projeto.objects;

import projeto.pt.iscte.poo.game.Gravity;
import projeto.pt.iscte.poo.gui.ImageGUI;
import projeto.pt.iscte.poo.utils.Direction;
import projeto.pt.iscte.poo.utils.Point2D;


public class Banana extends Projectile implements Gravity {
    private static final int DAMAGE = 10;

    public Banana(Point2D position) {
        super(position, DAMAGE);
        this.createImage();
        this.applyGravity();
    }

    @Override
    public void createImage() {
        ImageGUI.getInstance().addImage(this);
    }

    @Override
    public String getName() {
        return "Banana";
    }

    @Override
    public int getLayer() {
        return 0;
    }

    @Override
    public void applyGravity() {
        setPosition(getPosition().plus(Direction.DOWN.asVector()));
        if(getPosition().getY() == 9) {
            removeImage();
        }
    }
}
