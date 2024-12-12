package projeto.objects;

import projeto.pt.iscte.poo.utils.Point2D;

public class Stairs extends GameObject {

    public Stairs(Point2D position) {
        super(position);
    }


    @Override
    public String getName() {return "Stairs";}

    @Override
    public int getLayer() {return 1;}

    @Override
    public boolean isClimbable() {return true;}

    @Override
    public boolean isDestroyable() {return false;}

}
