package projeto.objects;

import projeto.pt.iscte.poo.utils.Direction;
import projeto.pt.iscte.poo.utils.Point2D;
import static projeto.pt.iscte.poo.utils.Constants.DESTRUCTIBLE;

public abstract class Item extends GameObject {
    private int healthBonus;
    private int attackBonus;

    public Item(Point2D position, int healthBonus, int attackBonus) {
        super(position, DESTRUCTIBLE);
        this.attackBonus = attackBonus;
        this.healthBonus = healthBonus;
    }

}
