package semana06.sampleCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Teste_iterator_remove_SAFE {

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
		
		// Remocao segura com iterador	
		// Note que o metodo remove() invocado e' o do iterador  
		// e nao o da lista (este ultimo nao seria seguro)
		
		Iterator<Pessoa> it = pessoas.iterator();
		
		while(it.hasNext()) {
			Pessoa p = it.next();
			if( p.getPeso() > 65)
				it.remove();
		}
		
		// Mostrar na consola (a expressão lambda implementa a "action" de um Consumable<T>)
		pessoas.forEach(p -> System.out.println(p));
	}
}
