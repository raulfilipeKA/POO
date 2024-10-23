package semana04.pratica;
import java.util.ArrayList;
public class Canvas {
    private ArrayList<Figure> figures = new ArrayList<Figure>();

    public void addFigure(Figure figure){
        figures.add(figure);
    }

    public void removeFigure(Figure figure){
        figures.remove(figure);
    }

    public Figure biggestFigure(){
        Figure biggest = figures.get(0);
        for(Figure figure : figures){
            if(figure.area() > biggest.area()){
                biggest = figure;
            }
        }
        return biggest;
    }

    public void removeBiggestFigure(){
        Figure biggest = biggestFigure();
        figures.remove(biggest);
    }

    public double totalArea(){
        double totalArea = 0;
        for(Figure figure : figures){
            totalArea += figure.area();
        }
        return totalArea;
    }

    public void draw(){
        for(Figure figure : figures){
            System.out.println(figure);
        }
    }

    public static void main(String[] args) {
        Canvas canvas = new Canvas();
        canvas.addFigure(new Circle(0, 0, 5));
        canvas.addFigure(new Rectangle(0, 0, 5, 5));
        canvas.draw();
        System.out.println("Total area: " + canvas.totalArea());
        System.out.println("-----------remove biggest-----------------");
        canvas.removeBiggestFigure();
        canvas.draw();
        System.out.println("---------add circles-------------");
        canvas.addFigure(new Circle(1, 3, 2));
        canvas.addFigure(new Circle(1, 3, 3));
        canvas.draw();
        System.out.println("------------remove biggest--------------");
        canvas.removeBiggestFigure();
        canvas.draw();
    }
}
