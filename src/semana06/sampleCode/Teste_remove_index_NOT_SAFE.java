package semana06.sampleCode;

import java.util.ArrayList;
import java.util.List;

public class Teste_remove_index_NOT_SAFE {

	public static void main(String[] args) {
		
		List<Pessoa> pessoas = new ArrayList<>();		
		pessoas.add(new Pessoa("Ana", 60, 165));
		pessoas.add(new Pessoa("Tomas", 70, 165));
		pessoas.add(new Pessoa("Rita", 50, 160));
		pessoas.add(new Pessoa("Bruno", 80, 180));
		pessoas.add(new Pessoa("Joana", 55, 160));
		pessoas.add(new Pessoa("Guilherme", 75, 170));
		pessoas.add(new Pessoa("Vitor", 80, 185));
		pessoas.add(new Pessoa("Vasco", 50, 175));
		pessoas.add(new Pessoa("Pedro", 70, 170));
		
		// Remocao nao segura - Lanca excecao quando o ultimo elemento  
		// e' para remover e o penultimo nao. Alem disso nao funciona bem 
		// quando aparecem dois elementos consecutivos a remover
		for (int i=0; i!=pessoas.size(); i++)
			if (pessoas.get(i).getPeso() > 65)
				pessoas.remove(i);
		
		// Mostrar na consola
		pessoas.forEach(p -> System.out.println(p));
	}
}
