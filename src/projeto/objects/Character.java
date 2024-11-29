package projeto.objects;

import projeto.pt.iscte.poo.gui.ImageGUI;
import projeto.pt.iscte.poo.utils.Point2D;

public abstract class Character extends GameObject {
    private int HP;
    private int ATC;

    public Character(Point2D position, int health, int attack){
        super(position);
        HP = health;
        ATC = attack;
    }

    @Override
    public int getLayer() {
        return 1;
    }

    protected void getsHit(int damage){
        HP = Math.max(0, HP - damage);
    }

    public void attack(Character c){
        c.getsHit(ATC);
    }

    public boolean isDead(){
        if(HP == 0) {
            this.removeImage();
        }
        return HP == 0;
    }


}
