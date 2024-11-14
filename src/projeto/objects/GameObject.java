package projeto.objects;

import projeto.pt.iscte.poo.gui.ImageTile;
import projeto.pt.iscte.poo.utils.Point2D;

public abstract class GameObject implements ImageTile{

    private Point2D position;

    public GameObject(Point2D initialPosition){
        position = initialPosition;
    }

    //@Override
    public abstract String getName();

    //@Override
    public Point2D getPosition() {
        return position;
    }

    //@Override
    public int getLayer() {
        return 1;
    }
}
