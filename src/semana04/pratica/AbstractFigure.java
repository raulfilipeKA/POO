package semana04.pratica;

public abstract class AbstractFigure implements Figure {
    private int x;
    private int y;

    public AbstractFigure(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString(){
        return "x: " + x + " y: " + y + " Area: " + area() + " Perimeter: " + perimeter();
    }
}
