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

    public void move(Point2D p) { //todo passar direcao em vez de Point 2D
        Point2D position  = new Point2D(p.getX(), this.getPosition().getY());
        // positon é a posicao em x do jumpman e a posicao em y do kong
        // posicao inicial do kong this.getPosition()
        // posicao inicial mais vetor  this.getPosition().plus(VETOR)
        // a direcao é this.getposition().directionTo(position)
        // o VETOR é this.directionTo(position).asVector()
        Direction direction = this.getPosition().directionTo(position);
        setPosition(getPosition().plus(direction.asVector()));
        //setPosition(getPosition().plus(getPosition().directionTo(position).asVector()));
    }
}
