package semana07.fabricaDeObjetos;

import java.util.ArrayList;
import java.util.List;

public class Teste {

	public static void main(String[] args) {
		
		List<Veiculo> lista = new ArrayList<>();

		// criacao de objetos de varios sub-tipos
		lista.add(Veiculo.create("Carro", "Opel Corsa"));
		lista.add(Veiculo.create("Aviao", "TAP"));
		lista.add(Veiculo.create("Barco", "Rei dos 7 Mares"));
		lista.add(Veiculo.create("Carro", "Seat Leon"));

		// mostrar os objetos criados
		lista.forEach(v -> System.out.println(v));
	}


}
