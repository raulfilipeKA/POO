package projeto.objects;

import projeto.pt.iscte.poo.gui.ImageGUI;
import projeto.pt.iscte.poo.utils.Point2D;
import static projeto.pt.iscte.poo.utils.Constants.DESTRUCTIBLE;

public class Stairs extends GameObject {

    public Stairs(Point2D position) {
        super(position, !DESTRUCTIBLE);
        this.createImage();
    }

    @Override
    public void createImage(){ImageGUI.getInstance().addImage(this);}

    @Override
    public String getName() {return "Stairs";}

    @Override
    public int getLayer() {return 0;}

}
