package projeto.objects;

public class Bomb extends GameObject {
    public static final int DAMAGE = 99999;
    public static final int EXPLOSION_RADIUS = 1;
    public static final int TIMER = 20;
    private boolean blow = false;
    private int blowAt;

    public Bomb(JumpMan jumpMan, int time) {
        super(jumpMan.getPosition());
        blowAt = time+TIMER;
    }

    public int getBlowAt() {return blowAt;}
    public void blow() {blow = true;}
    public boolean isBlown() {return blow;}

    @Override
    public String getName() {return "Bomb";}

    @Override
    public int getLayer() {return 2;}

    @Override
    public boolean isDestroyable() {return false;}

    public int getDamage() {return DAMAGE;}
    public int getExplosionRadius() {return EXPLOSION_RADIUS;}
    public int getTimer() {return TIMER;}


}
