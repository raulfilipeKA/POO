package semana03.ordenacao;
public class Descending implements SortingPolicy{

	@Override
	public boolean isBefore(int a, int b) {

		return a>b;
	}

}

