package projeto.objects;

import projeto.pt.iscte.poo.utils.Point2D;

public class WallTrap extends Trap {
    private boolean isSet = false;

    public WallTrap(Point2D position) {
        super(position);
        this.createImage();
    }

    @Override
    public String getName() {return "Wall";}

    @Override
    public int getLayer() {return 1;}

    @Override
    public boolean isSet(){return isSet;}

    public void setTrap(){isSet = true;}

}
