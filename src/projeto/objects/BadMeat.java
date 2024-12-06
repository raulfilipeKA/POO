package projeto.objects;

import projeto.pt.iscte.poo.gui.ImageGUI;
import projeto.pt.iscte.poo.utils.Point2D;

public class BadMeat extends Item{

    public BadMeat(Point2D initialPosition, int healthBonus) {
        super(initialPosition, healthBonus, 0);
        this.createImage();
    }

    @Override
    public void createImage(){ImageGUI.getInstance().addImage(this);}

    @Override
    public String getName() {return "BadMeat";}

}
