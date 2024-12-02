package projeto.objects;

import projeto.pt.iscte.poo.utils.Direction;
import projeto.pt.iscte.poo.utils.Point2D;

import javax.swing.text.Position;

public class Bomb extends Projectile {
    private static final int DAMAGE = 99999;
    private static final int EXPLOSION_RADIUS = 1;


    public Bomb(JumpMan jumpMan) {
        super(jumpMan.getPosition(), DAMAGE);
    }

    @Override
    public String getName() {return "Bomb";}

    @Override
    public void removeImage() {this.removeImage();}

    @Override
    public int getLayer() {return 7;}

//    public void explode() {
//        for (int i = -EXPLOSION_RADIUS; i <= EXPLOSION_RADIUS; i++) {
//            for (int j = -EXPLOSION_RADIUS; j <= EXPLOSION_RADIUS; j++) {
//                Point2D position = new Point2D(getPosition().getX() + i, getPosition().getY() + j);
//                if (position.equals(getPosition())) {
//                    GameObject gameObject = whatsThere(position); // ver o metodo e aplicar
//                    if (gameObject.isDestructible()) {
//                        gameObject.destroy();
//                    }
//                }
//            }
//        }
//        removeImage();
//    }


}
