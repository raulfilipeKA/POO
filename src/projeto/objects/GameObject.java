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
    }

    public abstract void createImage();

    public void removeImage(){
        ImageGUI.getInstance().removeImage(this);
        //remover a imagem e ( todo apagar o objeto? removendo todas as referências a ele?)
    }

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

}


