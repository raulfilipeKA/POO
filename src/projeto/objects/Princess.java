package projeto.objects;

import projeto.pt.iscte.poo.gui.ImageGUI;
import projeto.pt.iscte.poo.utils.Point2D;

import static projeto.pt.iscte.poo.utils.Constants.DESTRUCTIBLE;


public class Princess extends GameObject {

    public Princess(Point2D position) {
        super(position, DESTRUCTIBLE);
        this.createImage();
    }

    @Override
    public void createImage(){ImageGUI.getInstance().addImage(this);}

    @Override
    public String getName() {return "Princess";}

    @Override
    public int getLayer() {
        return 5;
    }

}
