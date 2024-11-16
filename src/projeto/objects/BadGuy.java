package projeto.objects;

import projeto.pt.iscte.poo.gui.ImageGUI;
import projeto.pt.iscte.poo.utils.Point2D;

public class BadGuy extends GameObject {

    public BadGuy(Point2D position, int healthBonus) {
        super(position);
        this.createImage();
    }

    @Override
    public void createImage(){ImageGUI.getInstance().addImage(this);}

    @Override
    public String getName() {return "BadGuy";}

}
