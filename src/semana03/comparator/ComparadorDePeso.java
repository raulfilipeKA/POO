package semana03.comparator;
import java.util.Comparator;

public class ComparadorDePeso implements Comparator<Pessoa>{

	@Override
	public int compare(Pessoa o1, Pessoa o2) {

		return o1.getPeso() - o2.getPeso();
	}

}
