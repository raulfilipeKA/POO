package projeto.objects;

import projeto.pt.iscte.poo.utils.Point2D;

import static projeto.pt.iscte.poo.utils.Constants.DESTRUCTIBLE;

public abstract class Mob extends GameObject {
    private int health;
    private int attack;

    public Mob(Point2D position, int health, int attack){
        super(position, DESTRUCTIBLE);
        this.health = health;
        this.attack = attack;
    }
}
