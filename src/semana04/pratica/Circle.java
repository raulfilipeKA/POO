package semana04.pratica;

public class Circle extends AbstractFigure{
    private int x;
    private int y;
    private int radius;

    public Circle(int x, int y, int radius){
        super(x, y);
        this.radius = radius;
    }

    public double area(){
        return Math.PI*radius*radius;
    }
    public double perimeter(){
        return 2*Math.PI*radius;
    }
}
