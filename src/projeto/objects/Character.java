package projeto.objects;

import projeto.pt.iscte.poo.gui.ImageGUI;
import projeto.pt.iscte.poo.utils.Point2D;

public abstract class Character extends GameObject {
    private static int HP;
    private int ATC;
    protected Point2D position;

    static {
        if(HP == 0){
           // remover a imagem do personagem
            //ImageGUI.getInstance().removeImage(this);
            // ImageGUI.getInstance().clearImages();
        }
    }

    public Character(Point2D position, int health, int attack){
        super(position);
        HP = health;
        ATC = attack;
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

    protected void getsHit(int damage){
        HP = Math.max(0, HP - damage);
    }


}
