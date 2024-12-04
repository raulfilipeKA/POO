package projeto.objects;

import projeto.pt.iscte.poo.gui.ImageGUI;
import projeto.pt.iscte.poo.utils.Point2D;

public class Sword extends Item{
    private static int DAMAGE = 20;

    public Sword(Point2D position) {
        super(position, 0, DAMAGE);
        this.createImage();
    }

    @Override
    public void createImage(){
        ImageGUI.getInstance().addImage(this);}

    @Override
    public String getName() {return "Sword";}
}
