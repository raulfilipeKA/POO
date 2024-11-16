package projeto.objects;

import projeto.pt.iscte.poo.gui.ImageGUI;
import projeto.pt.iscte.poo.utils.Point2D;

public class Green extends GameObject {

    public Green(Point2D position) {
        super(position);
        this.createImage();
    }

    @Override
    public void createImage(){ImageGUI.getInstance().addImage(this);}

    @Override
    public String getName() {return "Green";}

}
