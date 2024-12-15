package projeto.objects;

import projeto.pt.iscte.poo.utils.Direction;
import projeto.pt.iscte.poo.utils.Point2D;

public class Bat extends Character {
    private static int DAMAGE = 20;
    private static int HEALTH = 1;

    public Bat(Point2D position) {
        super(position, HEALTH, DAMAGE);
    }
    @Override
    public String getName() {return "Bat";}

}
