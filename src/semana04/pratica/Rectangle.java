package semana04.pratica;

public class Rectangle extends AbstractFigure{
    private int x;
    private int y;
    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height){
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public double area(){
        return width*height;
    }
    public double perimeter(){
        return 2*(width+height);
    }
}
