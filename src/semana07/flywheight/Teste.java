package semana07.flywheight;

public class Teste {

	public static void main(String[] args) {
		
		// Obter algumas cores, algumas delas repetidas
		Color c1 = Color.getColor(100, 200, 20);
		Color c2 = Color.getColor(100, 200, 20);
		Color c3 = Color.getColor(255, 200, 255);
		Color c4 = Color.getColor(100, 200, 20);
		Color c5 = Color.getColor(255, 200, 255);
		Color c6 = Color.getColor(0, 0, 0);
		
		// Apenas 3 objetos foram criados
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);
		System.out.println(c6);
	}

}
