package projeto.objects;

import projeto.pt.iscte.poo.utils.Point2D;

public class Key extends GameObject {

    public Key(Point2D position) {
        super(position);
    }

    @Override
    public String getName() {return "Key";}

    @Override
    public boolean isDestroyable() {return false;}

}
