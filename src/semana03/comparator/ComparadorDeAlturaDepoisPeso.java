package  semana03.comparator;
import java.util.Comparator;

public class ComparadorDeAlturaDepoisPeso implements Comparator<Pessoa>{

	@Override
	public int compare(Pessoa o1, Pessoa o2) {
		// Compara por altura e, em caso de empate, por peso
		if (o1.getAltura()==o2.getAltura())
			return o1.getPeso() - o2.getPeso();
		
		return o1.getAltura() - o2.getAltura();
	}

	
}
