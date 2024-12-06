package projeto.objects;

import projeto.pt.iscte.poo.gui.ImageGUI;
import projeto.pt.iscte.poo.utils.Point2D;

public class DoorClosed extends Door {

    public DoorClosed(Point2D position) {
        super(position);
        this.createImage();
    }

    @Override
    public void createImage(){ImageGUI.getInstance().addImage(this);}

    @Override
    public String getName() {return "DoorClosed";}

    public boolean isDoorOpen() {return false;}


//    public void openDoor() {
//        this.removeImage();
//        DoorOpen doorOpen = new DoorOpen(this.getPosition());
//    }

}