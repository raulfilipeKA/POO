package semana06.sampleCode;

import java.util.ArrayList;
import java.util.List;

public class Teste_removeIf_SAFE {

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
		
		// Solucao segura que minimiza a quantidade de codigo
		// Usa-se removeIf() e define-se um Predicate com exp. lambda
		 pessoas.removeIf(p -> p.getPeso() > 65);
		
		// Mostrar na consola
		pessoas.forEach(p -> System.out.println(p));
	}
}
