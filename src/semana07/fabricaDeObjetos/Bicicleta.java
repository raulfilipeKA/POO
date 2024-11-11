package semana07.fabricaDeObjetos;

public class Bicicleta extends Veiculo {

	private String tipo;

	public Bicicleta(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return "Bicicleta do tipo " + tipo;
	}
	
	
}