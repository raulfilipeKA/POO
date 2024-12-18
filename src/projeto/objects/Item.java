package projeto.objects;

import projeto.pt.iscte.poo.utils.Point2D;

public abstract class Item extends GameObject {
    private int healthBonus;
    private int attackBonus;

    public Item(Point2D position, int healthBonus, int attackBonus) {
        super(position);
        this.attackBonus = attackBonus;
        this.healthBonus = healthBonus;
    }

    @Override
    public int getLayer() {return 0;}

    public int getHealthBonus() {return healthBonus;}

    public int getAttackBonus() {return attackBonus;}

    protected void setHealthBonus(int healthBonus) {this.healthBonus = healthBonus;}
    protected void setAttackBonus(int attackBonus) {this.attackBonus = attackBonus;}

}
