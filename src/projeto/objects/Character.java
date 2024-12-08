package projeto.objects;

import projeto.pt.iscte.poo.utils.Point2D;

public abstract class Character extends GameObject {
    private int HP;
    private int ATC;

    public Character(Point2D position, int health, int attack){
        super(position, false);
        HP = health;
        ATC = attack;
    }

    protected void getsHit(int damage){
        HP = Math.max(0, HP - damage);
        if (HP == 0) {
            this.removeImage();

            // Código ANSI para texto vermelho
            String redText = "\u001B[31m";
            // Código ANSI para resetar a cor
            String resetText = "\u001B[0m";

            System.out.println(redText + "KILLED" + resetText);


        }
    }

    @Override
    public boolean canGoThrough() {return false;}

    public void attack(Character c){
        c.getsHit(ATC);
    }

    public boolean isDead(){
        if(HP == 0) {
            this.removeImage();
        }
        return HP == 0;
    }

    public void setAttack(int attack){ATC = attack;}
    public void setHealthBonus(int bonus){HP += bonus;}

    public int getAttack(){return ATC;}
    public int getHealth(){return HP;}




}
