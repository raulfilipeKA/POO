package semana07.solitao;

public class MySingleton {

	private static MySingleton INSTANCE = null;

	private MySingleton() {
	}
	
	public static MySingleton getInstance() {
		if (INSTANCE == null)
			INSTANCE = new MySingleton();
		return INSTANCE;
	}
	
	public void metodo1() {
		System.out.println("A fazer tarefa 1");
	}

	public void metodo2() {
		System.out.println("A fazer tarefa 2");
	}
}
