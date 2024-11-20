package projeto.objects;

import projeto.pt.iscte.poo.utils.Direction;
import projeto.pt.iscte.poo.utils.Point2D;
import projeto.pt.iscte.poo.gui.*;
import java.util.ArrayList;

public abstract class GameObject implements ImageTile{

    private Point2D position;

    public GameObject(Point2D initialPosition){
        position = initialPosition;
    }

    public abstract void createImage(); //se implementar aqui e nao tenho os get
    //name ele vai tentar criar a imagem antes de ter o nome

    public void removeImage(){
        ImageGUI.getInstance().removeImage(this);
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

    protected void setPosition(Point2D newPosition){
        position = newPosition;
    }

}


