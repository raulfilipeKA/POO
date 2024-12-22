package projeto.objects;

import projeto.pt.iscte.poo.utils.Direction;
import projeto.pt.iscte.poo.utils.Point2D;

import java.util.ArrayList;

public abstract class Character extends GameObject {
    private int HP;
    private int ATC;
    private ArrayList<Item> items = new ArrayList<>();

    public Character(Point2D position, int health, int attack){
        super(position);
        HP = health;
        ATC = attack;
    }

    public void getsHit(int damage){
        HP = Math.max(0, HP - damage);
//        if (HP == 0) {
//            // Código ANSI para texto vermelho
//            String redText = "\u001B[31m";
//            // Código ANSI para resetar a cor
//            String resetText = "\u001B[0m";
//
//            System.out.println(redText + "KILLED" + resetText);
//
//
//        }
    }

    @Override
    public boolean isDestroyable() {return false;}

    @Override
    public boolean canApplyGravity() {return true;}

    @Override
    public boolean canGoThrough() {return false;}

    @Override
    public boolean movableObject() {return true;}

    public void attack(Character c){
        c.getsHit(ATC);
    }

    public boolean isDead(){return HP <= 0;}


    public void setAttack(int attack){ATC = attack;}
    public void setHealthBonus(int bonus){HP += bonus;}

    public int getAttack(){return ATC;}
    public int getHealth(){return HP;}

    @Override
    public int getLayer() {return 7;}

    public void setHealth(int health) {this.HP = health;}

    public boolean canCatchItem(){return false;}

    public ArrayList<Item> getItems() {return items;}

    public void catchItem(Item item) {
        if (canCatchItem()) {
            HP += item.getHealthBonus();
            ATC += item.getAttackBonus();
            items.add(item);
        }
        System.out.println("---------------------");
        System.out.println("Items:" + this.getName());
        for(Item i : items){
            System.out.println(i.getName());
        }
    }

    public void lostItem(Item item) {
        if (canCatchItem()) {
            HP -= item.getHealthBonus();
            ATC -= item.getAttackBonus();
            items.remove(item);
        }
        System.out.println("---------------------");
        System.out.println("Items:"+ this.getName());
        for(Item i : items){
            System.out.println(i.getName());
        }
    }

    public void move(Point2D p) {
        Direction direction = this.getPosition().directionTo(p);
        setPosition(getPosition().plus(direction.asVector()));
    }


}
