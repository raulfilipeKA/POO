package projeto.objects;

import projeto.pt.iscte.poo.utils.Point2D;

public class DoorOpen extends Door {

    public DoorOpen(Point2D position) {
        super(position);
    }

    @Override
    public String getName() {return "DoorOpen";}

    public boolean isDoorOpen() {return true;}

}
