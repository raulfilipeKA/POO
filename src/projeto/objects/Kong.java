package projeto.objects;

import projeto.pt.iscte.poo.utils.Direction;
import projeto.pt.iscte.poo.utils.Point2D;

public class Kong extends Character {
    private static final int HP = 100;
    private static final int ATK = 10;


    public Kong(Point2D initialPosition) {
        //podemos multiplicar o numero da sala aos atributos de alguns personagens
        super(initialPosition, HP, ATK);
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
        //posso criar o maximo de bananas na room
        //depois um atributo boolean para saber se esta em jogo
        // se estiver out of bounds o kong pode voltar a lançar
        // se estiver em jogo cai ate acertar em alguem ou sair do jogo
        // isto para prevenir que o kong fique a lançar bananas sem parar
        //e que tenhamos que remover as bananas a meio da itercacao do move do kong

    }

    public void move(Point2D p) { //todo passar direcao em vez de Point 2D
        if(p.getX() == this.getPosition().getX()){return;}
        Direction direction = this.getPosition().directionTo(p);
        setPosition(getPosition().plus(direction.asVector()));

    }
}
