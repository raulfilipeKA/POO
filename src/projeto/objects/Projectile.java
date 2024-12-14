package projeto.objects;

import projeto.pt.iscte.poo.utils.Direction;
import projeto.pt.iscte.poo.utils.Point2D;

public abstract class Projectile extends GameObject {
    private int damage;
    private boolean outOfBounds=false;
    private boolean hit=false;

    public Projectile(Point2D position, int damage) {
        super(position);
        this.damage = damage;
    }

    public void movement(Direction d){this.setPosition(this.getPosition().plus(d.asVector()));}

    public void setOutOfBounds(boolean outOfBounds) {this.outOfBounds = outOfBounds;}
    public boolean getOutOfBounds() {return outOfBounds;}
    public void hit(boolean hit) {this.hit = hit;}
    public boolean getHit() {return hit;}


    public void hit(JumpMan j) {
        if(this.getPosition().equals(j.getPosition())) {
            j.getsHit(damage);
            removeImage(); //é suposto remover a imagem do projétil quando atinge o jogador?
            //ou deixa se continuar a cair? indiferente mas senao é apagar removeImage();
        }
    }
    @Override
    public boolean canGoThrough() {return false;}

    public void move(){
        System.out.println("BANANA MOVE");
    }

    public int getDamage() {return damage;}

    @Override
    public int getLayer() {return 50;}

}