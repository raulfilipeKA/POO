package projeto.objects;

import projeto.pt.iscte.poo.utils.Point2D;

public class Bat extends Character {

    public Bat(Point2D position, int health, int damage) {
        super(position, health, damage);
    }

    @Override
    public String getName() {return "Bat";}

}
