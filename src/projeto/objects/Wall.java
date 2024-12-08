package projeto.objects;

import projeto.pt.iscte.poo.gui.ImageGUI;
import projeto.pt.iscte.poo.utils.Point2D;

public class Wall extends GameObject {


    public Wall(Point2D position) {
        super(position, false);
        this.createImage();
    }

    @Override
    public void createImage(){ImageGUI.getInstance().addImage(this);}

    @Override
    public String getName() {
        return "Wall";
    }

    @Override
    public int getLayer() {return 0;}

    @Override
    public boolean canGoThrough() {return false;}



}
