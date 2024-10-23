package semana03.comparator;
import java.util.Comparator;

public class ComparadorDeNome implements Comparator<Pessoa>{

	@Override
	public int compare(Pessoa o1, Pessoa o2) {
	
		Comparator<String> c = String.CASE_INSENSITIVE_ORDER;
		return c.compare(o1.getNome(), o2.getNome());
	}

}
