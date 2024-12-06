package projeto.objects;

import projeto.pt.iscte.poo.utils.Point2D;

public abstract class Door extends GameObject {

    public Door(Point2D position) {
        super(position, false);
        this.createImage();
    }

//    public abstract boolean isDoorOpen();

}
