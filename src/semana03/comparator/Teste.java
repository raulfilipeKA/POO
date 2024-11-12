package semana03.comparator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Teste {

	public static void main(String[] args) {
		
		List<Pessoa> lista = new ArrayList<>();		
		lista.add(new Pessoa("Ana", 60, 165));
		lista.add(new Pessoa("Rita", 50, 160));
		lista.add(new Pessoa("Joana", 55, 160));
		lista.add(new Pessoa("Bruno", 80, 180));
		lista.add(new Pessoa("Tomas", 70, 165));
		lista.add(new Pessoa("Guilherme", 75, 170));
		lista.add(new Pessoa("Vitor", 80, 185));
		lista.add(new Pessoa("Pedro", 70, 170));
		lista.add(new Pessoa("Vasco", 50, 175));
		
		System.out.println("\n=== Lista ordenada por peso ===");
		lista.sort(new ComparadorDePeso());
		for (Pessoa p : lista)
			System.out.println(p);


		System.out.println("--------------cenas-----------------");
		lista.sort((o1, o2) -> (o2.getPeso() - o1.getPeso()));
		for (Pessoa p : lista)
			System.out.println(p);


		//System.out.println("---cenas 2 ---");
		//Comparator<Integer> comp = (o1, o2) -> o1 - o2;
		//lista.sort(comp);  //nao funciona pq o comparaor nao e do tipo pessoa

		System.out.println("\n=== Lista ordenada alfabeticamente por nome ===");
		lista.sort(new ComparadorDeNome());
		for (Pessoa p : lista)
			System.out.println(p);
		
		System.out.println("\n=== Lista ordenada por altura e, em caso de empate, por peso ===");
		lista.sort(new ComparadorDeAlturaDepoisPeso());
		for (Pessoa p : lista)
			System.out.println(p);
		
	}
}
