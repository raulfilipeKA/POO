package semana03;

public class Circle implements Drawable{

	private int radius;

	public Circle(int radius) {
		this.radius = radius;
	}

	@Override
	public void draw() {
		System.out.println("Desenhar um circulo de raio " + radius);
		
	}
	
	
}
