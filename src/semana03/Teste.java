package semana03;

import java.util.ArrayList;
import java.util.List;

public class Teste {

	public static void main(String[] args) {
		
		List<Drawable> figuras = new ArrayList<>();
		
		figuras.add(new Line(0,0,2,2));
		figuras.add(new Painting("Leonardo", "Mona Lisa"));
		figuras.add(new Circle(3));
		figuras.add(new Square(4));
		figuras.add(new Painting("Van Gogh", "Os girass�is"));
		figuras.add(new Square(2));
		
		for (Drawable d : figuras)
			d.draw();
	}
}
