package projeto.objects;

import projeto.pt.iscte.poo.gui.ImageGUI;
import projeto.pt.iscte.poo.gui.ImageTile;
import projeto.pt.iscte.poo.utils.Direction;
import projeto.pt.iscte.poo.utils.Point2D;

public abstract class GameObject implements ImageTile{

    private Point2D position;
    private boolean destroyed = false;
    //private final boolean isDestructible;

    public GameObject(Point2D initialPosition){
        position = initialPosition;
        this.createImage();
    }

    public void createImage(){ImageGUI.getInstance().addImage(this);}

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

    public void fall(){setPosition(getPosition().plus(Direction.DOWN.asVector()));}
    public boolean canApplyGravity(){return false;}

    public boolean canGoThrough(){return true;}

    public boolean isClimbable(){return false;}

    public boolean movableObject(){return false;}

    public boolean canTeleport(){return false;}

    public void destroy(){  //vai servir para apagar os objetos que forem rebentados
        //this.removeImage();
        destroyed = true;
    }

    public boolean isDestroyed(){return destroyed;}

    public void teleport(Point2D newPosition){ //podíamos criar dois objetos que serviam como portais
        if(canTeleport()){                     //mas é usado só para quando o jumpMan morre e tem que voltar ao início da sala
            this.removeImage();
            position = newPosition;
            this.createImage();
        } else { System.out.println("This object cannot be teleported");}
    }


}


