package semana07.solitao;

public class ClassB {

	// E' possivel obter a referencia do solitao
	// sem que esta necessite de ser passada a objetos desta classe
	// Basta fazer MySingleton.getInstance()
	
	public void processamento() {
		System.out.println("Processamento da classe B:");
		MySingleton.getInstance().metodo1();
	}
}

