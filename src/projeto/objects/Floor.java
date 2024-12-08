package projeto.objects;

import projeto.pt.iscte.poo.utils.Point2D;

public class Floor extends GameObject {

    public Floor(Point2D position) {
        super(position, false);
    }

    @Override
    public String getName() {
        return "Floor";
    }

    @Override
    public int getLayer() {return 0;}

}
