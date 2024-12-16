package projeto.objects;

import projeto.pt.iscte.poo.utils.Point2D;

public class Trap extends GameObject {
    private static final int DAMAGE = 5;


    public Trap(Point2D position) {
        super(position);
    }

    public int getDamage() {return DAMAGE;}

    @Override
    public String getName() {return "Trap";}

    @Override
    public boolean canGoThrough() {return false;}

    @Override
    public boolean isDestroyable() {return false;}

    public boolean isSet(){return true;}

    public void trapJumpMan(JumpMan jumpMan){jumpMan.getsHit(DAMAGE);}

}
