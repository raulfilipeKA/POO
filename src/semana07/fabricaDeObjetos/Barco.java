package semana07.fabricaDeObjetos;

public class Barco extends Veiculo {

	private String nome;

	public Barco(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "Barco chamado " + nome;
	}
}