package projeto.objects;

import projeto.pt.iscte.poo.utils.Point2D;

public class GoodMeat extends Item {
    private final static int HEALTH_BONUS = 10;
    public final static int TIME_TO_ROT = 20;

    public GoodMeat(Point2D position) {
        super(position, HEALTH_BONUS, 0);
    }

    @Override
    public String getName() {return "GoodMeat";}

}
