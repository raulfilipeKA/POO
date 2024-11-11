package semana07.fabricaDeObjetos;


public class Carro extends Veiculo {

	private String modelo;

	public Carro(String modelo) {
		this.modelo = modelo;
	}

	public String getModelo() {
		return modelo;
	}

	@Override
	public String toString() {
		return "Carro de marca/modelo " + modelo;
	}
}
