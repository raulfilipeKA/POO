package projeto.objects;

public class Bomb extends GameObject {
    public static final int DAMAGE = 99999;
    public static final int EXPLOSION_RADIUS = 1;
    public static final int TIMER = 5;
    private boolean armed = false;


    public Bomb(Character character) {
        super(character.getPosition());
    }

    @Override
    public String getName() {return "Bomb";}

    @Override
    public int getLayer() {return 10;}

    public void arm() {armed = true;}

    @Override
    public boolean isDestroyable() {return false;}

}
