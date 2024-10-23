package semana03.ordenacao;
public class EvenFirstAscending implements SortingPolicy {

	@Override
	public boolean isBefore(int a, int b) {
		
		if (a%2==0 && b%2==0)
			return a<b;
		
		if (a%2!=0 && b%2!=0)
			return a<b;
		
		if (a%2==0 && b%2!=0)
			return true;
		
		return false;
	}

}
