package projeto.objects;

import projeto.pt.iscte.poo.utils.Point2D;

public class DoorClosed extends Door {

    public DoorClosed(Point2D position) {
        super(position);
    }

    @Override
    public String getName() {return "DoorClosed";}

    public boolean isDoorOpen() {return false;}

}