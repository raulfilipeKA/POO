package semana03.ordenacao;
public class Ascending implements SortingPolicy{

	@Override
	public boolean isBefore(int a, int b) {

		return a<b;
	}

}
