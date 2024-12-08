package projeto.objects;

import projeto.pt.iscte.poo.gui.ImageGUI;
import projeto.pt.iscte.poo.utils.Point2D;

public class Stairs extends GameObject {

    public Stairs(Point2D position) {
        super(position, false);
        this.createImage();
    }

    @Override
    public void createImage(){ImageGUI.getInstance().addImage(this);}

    @Override
    public String getName() {return "Stairs";}

    @Override
    public int getLayer() {return 1;}

    @Override
    public boolean isClimbable() {return true;}

}
