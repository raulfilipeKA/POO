package projeto.objects;

import projeto.pt.iscte.poo.gui.ImageGUI;
import projeto.pt.iscte.poo.utils.Point2D;

public class GoodMeat extends Item {
    private static int healthBonus;

    public GoodMeat(Point2D position) {
        super(position);
        this.createImage();
    }

    @Override
    public void createImage(){ImageGUI.getInstance().addImage(this);}

    @Override
    public String getName() {return "GoodMeat";}

}
