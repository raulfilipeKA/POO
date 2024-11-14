package projeto.objects;

import projeto.pt.iscte.poo.utils.Point2D;

public abstract class Character extends GameObject {
    private int health;
    private int attack;
    protected Point2D position;


    public Character(Point2D position, int health, int attack){
        super(position);
        this.health = health;
        this.attack = attack;
        this.position = position;

    }

    @Override
    public int getLayer() {
        return 1;
    }

    @Override
    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }


}
