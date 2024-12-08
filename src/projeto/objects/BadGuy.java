package projeto.objects;

import projeto.pt.iscte.poo.utils.Point2D;

public class BadGuy extends Character {

    public BadGuy(Point2D position, int health, int attack) {
        super(position, health, attack);
    }

    @Override
    public String getName() {return "BadGuy";}

}
