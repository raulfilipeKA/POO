package semana07.flywheight;

import java.util.ArrayList;
import java.util.List;

public final class Color {

	private final int value; 
	
	// Lista para guardar as cores que forem sendo criadas
	private static List<Color> colors = new ArrayList<>();

	// construtor private
	private Color(int value) {
		this.value = value;
	}

	// metodo fabrica que inclui controlo de instancias
	public static Color getColor(int r, int g, int b) {
		
		int v = encode(r, g, b);
		
		// verifica se a cor já existe - se sim obtem e devolve
		for (Color c : colors)
			if (c.getValue() == v) 
				return c;
		
		// se a cor ainda nao existir, cria, coloca na lista, e devolve
		Color c = new Color(v);
		colors.add(c);
		
		return c;
	}
	
	private int getValue() {
		return value;
	}

	private static int encode(int r, int g, int b) {
		return r<<16 | g<<8 | b;
	}
	
	public int getR() {	
		return (value >> 16) & 0xFF;
	}
	
	public int getG() {	
		return (value >> 8) & 0xFF;
	}
	
	public int getB() {	
		return value & 0xFF;
	}
	
	public Color copy() {
		return new Color(value);
	}
	
	@Override 
	public String toString() {
		return "("+getR()+","+getG()+","+getB()+") \tObjID: " + hashCode();
	}
	
	
	
}
