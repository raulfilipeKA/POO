package semana04.pratica;

public class TesteFigures {
    public static void main(String[] args) {
        AbstractFigure c = new Circle(1, 2, 3);
        Figure r = new Rectangle(4, 5, 6, 7);
        Circle c2 = new Circle(3, 1, 2);
        System.out.println("Circle area: " + c.area());
        System.out.println("Circle perimeter: " + c.perimeter());
        System.out.println("Rectangle area: " + r.area());
        System.out.println("Rectangle perimeter: " + r.perimeter());
    }
}
