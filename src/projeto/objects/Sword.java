package projeto.objects;

import projeto.pt.iscte.poo.utils.Point2D;

public class Sword extends Item{
    private static int DAMAGE = 20;

    public Sword(Point2D position) {
        super(position, 0, DAMAGE);
    }


    @Override
    public String getName() {return "Sword";}
}
