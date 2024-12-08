package projeto.objects;

import projeto.pt.iscte.poo.gui.ImageGUI;
import projeto.pt.iscte.poo.utils.Direction;
import projeto.pt.iscte.poo.utils.Point2D;

public abstract class Projectile extends GameObject {
    private int damage;

    public Projectile(Point2D position, int damage) {
        super(position, true);
        this.damage = damage;
    }

    @Override
    public void createImage() {ImageGUI.getInstance().addImage(this);}

    public void movement(Direction d){this.setPosition(this.getPosition().plus(d.asVector()));}

    public abstract void removeImage();


    public void hit(JumpMan j) {
        if(this.getPosition().equals(j.getPosition())) {
            j.getsHit(damage);
            removeImage(); //é suposto remover a imagem do projétil quando atinge o jogador?
            //ou deixa se continuar a cair? indiferente mas senao é apagar removeImage();
        }
    }
    @Override
    public boolean canGoThrough() {return false;}

}