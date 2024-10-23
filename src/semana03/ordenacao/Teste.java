package semana03.ordenacao;
public class Teste {

	public static void main(String[] args) {

		int[] v = {13, 2, 57, 3, 6, 90, 5, 8, 10};

		System.out.println("Antes de ordenar");
		show(v);

		//sortAscending(v);
		sort(v, new Ascending());
		System.out.println("Ordem crescente");
		show(v);
	
		//sortDescending(v);
		sort(v, new Descending());
		System.out.println("Ordem descrescente");
		show(v);
		
		sort(v, new EvenFirstAscending());
		System.out.println("Pares primeiro, ordem crescente");
		show(v);
		
	}

	// Solucao flexivel - um unico metodo, e o criterio de ordenacao
	// e' um objeto passado ao metodo atraves do uso de um interface
	
	public static void sort(int[] v, SortingPolicy policy) {

		for (int i=0; i!=v.length-1; i++)
			for (int j=1; j!=v.length-i; j++)
				if (policy.isBefore(v[j], v[j-1])) {
					int aux = v[j-1];
					v[j-1] = v[j];
					v[j] = aux;
				}
	}
	
	private static void show(int[] v) {

		for (int n : v)
			System.out.println(n);
	}

	
	// Metodos originais - pouco flexiveis pq obrigam a
	// a implementar metodos repetitivos quando a �nica coisa
	// que muda e' criterio de ordenacao e nao o algoritmo
	
	public static void sortAscending(int[] v) {

		for (int i=0; i!=v.length-1; i++)
			for (int j=1; j!=v.length-i; j++)
				if (v[j] < v[j-1]) {
					int aux = v[j-1];
					v[j-1] = v[j];
					v[j] = aux;
				}
	}
	public static void sortDescending(int[] v) {

		for (int i=0; i!=v.length-1; i++)
			for (int j=1; j!=v.length-i; j++)
				if (v[j] > v[j-1]) {
					int aux = v[j-1];
					v[j-1] = v[j];
					v[j] = aux;
				}
	}	
}
