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

    public void move() {
        //if level is <4, move randomly
        //super.getPosition() = getPosition().plus(Direction.random().asVector());
        //implementar na classe Room
        //position = position.plus(Direction.random().asVector());
    }
}
