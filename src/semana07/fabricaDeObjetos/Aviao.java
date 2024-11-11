package semana07.fabricaDeObjetos;

public class Aviao extends Veiculo {

	private String companhia;

	public Aviao(String companhia) {
		this.companhia = companhia;
	}

	public String getCompanhia() {
		return companhia;
	}

	@Override
	public String toString() {
		return "Aviao da companhia aerea " + companhia;
	}


}