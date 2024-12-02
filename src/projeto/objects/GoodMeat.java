package projeto.objects;

import projeto.pt.iscte.poo.gui.ImageGUI;
import projeto.pt.iscte.poo.utils.Point2D;

public class GoodMeat extends Item {
    private static int HEALTHBONUS = 10;

    public GoodMeat(Point2D position) {
        super(position, HEALTHBONUS, 0);
        this.createImage();
    }

    @Override
    public void createImage(){ImageGUI.getInstance().addImage(this);}

    @Override
    public String getName() {return "GoodMeat";}

}
