package projeto.objects;

import projeto.pt.iscte.poo.utils.Point2D;
public class Green extends GameObject {


    public Green(Point2D position) {
        super(position, true);
    }

    @Override
    public String getName() {return "Green";}

}
