package projeto.objects;

public class Bomb extends Projectile {
    public static final int DAMAGE = 99999;
    public static final int EXPLOSION_RADIUS = 1;


    public Bomb(Character character) {
        super(character.getPosition(), DAMAGE);
    }

    @Override
    public String getName() {return "Bomb";}

    @Override
    public void removeImage() {this.removeImage();}

    @Override
    public int getLayer() {return 7;}




}
