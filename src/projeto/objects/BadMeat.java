package projeto.objects;

import projeto.pt.iscte.poo.utils.Point2D;

public class BadMeat extends Item{

    public BadMeat(Point2D initialPosition, int healthBonus) {
        super(initialPosition, healthBonus, 0);
    }

    @Override
    public String getName() {return "BadMeat";}

}
