package projeto.objects;

import projeto.pt.iscte.poo.gui.ImageGUI;
import projeto.pt.iscte.poo.utils.Point2D;

public class Hammer extends Item {
    private static int DAMAGE = 10;

    public Hammer(Point2D position) {
        super(position, 0, DAMAGE);
        this.createImage();
    }

    @Override
    public void createImage(){ImageGUI.getInstance().addImage(this);}

    @Override
    public String getName() {return "Hammer";}

}
