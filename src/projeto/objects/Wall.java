package projeto.objects;

import projeto.pt.iscte.poo.utils.Point2D;

public class Wall extends GameObject {


    public Wall(Point2D position) {
        super(position);
    }

    @Override
    public String getName() {
        return "Wall";
    }

    @Override
    public int getLayer() {return 0;}

    @Override
    public boolean canGoThrough() {return false;}

    @Override
    public boolean isDestroyable() {return false;}


}
