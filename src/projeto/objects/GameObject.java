package projeto.objects;

import projeto.pt.iscte.poo.gui.ImageGUI;
import projeto.pt.iscte.poo.gui.ImageTile;
import projeto.pt.iscte.poo.utils.Point2D;

public abstract class GameObject implements ImageTile{

    private Point2D position;
    //private final boolean isDestructible;

    public GameObject(Point2D initialPosition){
        position = initialPosition;
        this.createImage();
    }

    public void createImage(){ImageGUI.getInstance().addImage(this);} //nao invoco no construtor super
    //porque como depende do getName(), tenho que invocar na subclasse onde ja o implementei

    public void removeImage(){ImageGUI.getInstance().removeImage(this);}


    public boolean isDestroyable() {return true;}

    //public  boolean isDestructible(){return true;}

    @Override
    public abstract String getName();

    @Override
    public Point2D getPosition() {return position;}

    @Override
    public int getLayer() {
        return 5;
    }

    public void setPosition(Point2D newPosition){
        this.removeImage();
        position = newPosition;
        this.createImage();
    }

    public boolean canGoThrough(){return true;}

    public boolean isClimbable(){return false;}

    public boolean movableObject(){return false;}

    public boolean canTeleport(){return false;}

    public void teleport(Point2D newPosition){
        if(canTeleport()){
            this.removeImage();
            position = newPosition;
            this.createImage();
        } else { System.out.println("This object cannot be teleported");}
    }


}


