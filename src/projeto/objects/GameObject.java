package projeto.objects;

import projeto.pt.iscte.poo.gui.ImageTile;
import projeto.pt.iscte.poo.utils.Point2D;
import projeto.pt.iscte.poo.gui.ImageGUI;

import java.util.ArrayList;
import java.util.List;

public abstract class GameObject implements ImageTile{

    private Point2D position;
    private ArrayList<GameObject> objects = new ArrayList<>();

    public GameObject(Point2D initialPosition){
        position = initialPosition;
        objects.add(this);
    }

    public abstract void createImage(); //se implementar aqui e nao tenho os get
    //name ele vai tentar criar a imagem antes de ter o nome

    public void removeImage(){
        ImageGUI.getInstance().removeImage(this);
    }

    protected ArrayList<GameObject> getObjects() {
        return objects;
    }

    protected boolean isValidMove(Point2D newPosition){
        for(GameObject object : objects){
            if(object.getPosition().equals(newPosition)){
                return false;
            }
        }
        return true;
    }

    @Override
    public abstract String getName();

    @Override
    public Point2D getPosition() {
        return position;
    }

    @Override
    public int getLayer() {
        return 1;
    }

}


