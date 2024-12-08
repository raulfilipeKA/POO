package projeto.objects;

import projeto.pt.iscte.poo.gui.ImageGUI;
import projeto.pt.iscte.poo.gui.ImageTile;
import projeto.pt.iscte.poo.utils.Point2D;

public abstract class GameObject implements ImageTile{

    private Point2D position;
    private final boolean isDestructible;

    public GameObject(Point2D initialPosition, boolean isDestructible){
        position = initialPosition;
        this.isDestructible = isDestructible;
        this.createImage();
    }

    public void createImage(){ImageGUI.getInstance().addImage(this);} //nao invoco no construtor super
    //porque como depende do getName(), tenho que invocar na subclasse onde ja o implementei

    public void removeImage(){ImageGUI.getInstance().removeImage(this);}

    public boolean isDestructible(){return isDestructible;}

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
        position = newPosition;
    }

    public boolean canGoThrough(){return true;}

    public boolean isClimbable(){return false;}

}


