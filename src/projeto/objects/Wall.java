package projeto.objects;

import projeto.pt.iscte.poo.utils.Point2D;

public class Wall extends GameObject {

    public Wall(Point2D p) {
        super(p);
    }

    @Override
    public String getName() {
        return "Wall";
    }

}
