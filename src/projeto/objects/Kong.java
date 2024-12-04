package projeto.objects;

import projeto.pt.iscte.poo.gui.ImageGUI;
import projeto.pt.iscte.poo.utils.Direction;
import projeto.pt.iscte.poo.utils.Point2D;

public class Kong extends Character {
    private static final int HP = 100;
    private static final int ATK = 10;


    public Kong(Point2D initialPosition) {
        //podemos multiplicar o numero da sala aos atributos de alguns personagens
        super(initialPosition, HP, ATK);
        this.createImage();
    }

    @Override
    public void createImage(){
        ImageGUI.getInstance().addImage(this);
    }

    @Override
    public String getName() {
        return "DonkeyKong";
    }

//    public void move() { //move randomly lvl 1-4 //todo Point2D ou Direction? É indiferente?
//        //Direction d = Direction.random();
//        Point2D p = this.getPosition().plus(Direction.random().asVector());
//        this.move(p);
//        //setPosition(getPosition().plus(d.asVector()));
//    }

    public void deployProjectile(Projectile proj){

    }

    public void move(Point2D p) { //todo passar direcao em vez de Point 2D
        if(p.getX() == this.getPosition().getX()){return;}
        Direction direction = this.getPosition().directionTo(p);
        setPosition(getPosition().plus(direction.asVector()));

    }
}
