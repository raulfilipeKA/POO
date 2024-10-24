package semana06.sampleCode;

import java.util.ArrayList;
import java.util.List;

public class Teste_removeAll_SAFE {

	public static void main(String[] args) {
		List<Pessoa> pessoas = new ArrayList<>();		
		pessoas.add(new Pessoa("Ana", 60, 165));
		pessoas.add(new Pessoa("Tomas", 70, 165));
		pessoas.add(new Pessoa("Rita", 50, 160));
		pessoas.add(new Pessoa("Bruno", 80, 180));
		pessoas.add(new Pessoa("Joana", 55, 160));
		pessoas.add(new Pessoa("Guilherme", 75, 170));
		pessoas.add(new Pessoa("Vitor", 80, 185));
		pessoas.add(new Pessoa("Pedro", 70, 170));
		pessoas.add(new Pessoa("Vasco", 50, 175));
		
		// Remocao segura com removeAll()
		// A abordagem consiste em construir uma lista auxiliar com os elementos
		// a remover e no final utiliza-se o metodo removeAll()
		List<Pessoa> aux = new ArrayList<>();
		
		for (Pessoa p : pessoas)
			if (p.getPeso() > 65)
				aux.add(p);
		
		pessoas.removeAll(aux);
		
		pessoas.forEach(p -> System.out.println(p));

	}

}
