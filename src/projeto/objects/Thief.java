package projeto.objects;

import projeto.pt.iscte.poo.utils.Direction;
import projeto.pt.iscte.poo.utils.Point2D;

import java.util.ArrayList;

public class Thief extends Character{
    private ArrayList<Point2D> positionsHistory = new ArrayList<>();
    private  boolean stole=false;

    public Thief(Point2D initialPosition) {
        super(initialPosition, 1, 0);
        positionsHistory.add(initialPosition);
    }

    @Override
    public String getName() {return "Thief";}

    public void move(JumpMan jumpMan) {
        if (((jumpMan.getPosition().getY())==((getPosition().getY()))) && !stole
        && !jumpMan.getPosition().equals(getPosition())) {
            System.out.println("EFESMFEJRFERF");
            moveTowards(jumpMan.getPosition());
            positionsHistory.add(getPosition());
        }
        if(jumpMan.getPosition().equals(getPosition()) && !stole){
            System.out.println("BABAABABABA");
            stole = true;
            steal(jumpMan);
        }
        if (stole) {undoMove();}
    }

    public void moveTowards(Point2D position) {
        if (position.getX() > getPosition().getX()) {
            setPosition(getPosition().plus(Direction.RIGHT.asVector()));
        } else if (position.getX() < getPosition().getX()) {
            setPosition(getPosition().plus(Direction.LEFT.asVector()));
        }
        positionsHistory.add(getPosition());
    }

    public void undoMove() {
        if (positionsHistory.size() > 1) {
            Point2D lastPosition = positionsHistory.getLast();
            setPosition(lastPosition);
            positionsHistory.removeLast();
        }
    }

    public void steal(JumpMan jumpMan) {
        if (!jumpMan.getItems().isEmpty()) {
            Item item = jumpMan.getItems().getLast();
            jumpMan.lostItem(item);
            System.out.println("Thief stole " + item.getName());
        }
        System.out.println("---------------------");
        System.out.println("ITems restantes do jumpMan");
        for (Item i : jumpMan.getItems()) {
            System.out.println(i.getName());
        }
    }

    @Override
    public void move(Point2D p) {
        Direction direction = this.getPosition().directionTo(p);
        setPosition(getPosition().plus(direction.asVector()));
        positionsHistory.add(getPosition());
    }

    @Override
    public boolean canCatchItem(){return true;}

    @Override
    public  boolean canGoThrough(){return true;}

    public boolean stole() {
        return stole;
    }
}
