package projeto.objects;

import projeto.pt.iscte.poo.utils.Point2D;

public class Key extends GameObject {

    public Key(Point2D position) {
        super(position, true);
    }

    @Override
    public String getName() {return "Key";}

}
