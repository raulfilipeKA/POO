package projeto.objects;

import projeto.pt.iscte.poo.utils.Point2D;

public class Trap extends GameObject {

    public Trap(Point2D position) {
        super(position);
    }


    @Override
    public String getName() {return "Trap";}

    @Override
    public boolean canGoThrough() {return false;}

    @Override
    public boolean isDestroyable() {return false;}

}
