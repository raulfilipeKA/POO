package semana07.fabricaDeObjetos;


public abstract class Veiculo {

	// metodo fabrica: 
	//        type - subtipo do objeto a criar
	//        info - argumentos para o contrutor do objeto a criar
	public static Veiculo create(String type, String info) {
		
		switch(type) {
		
		case "Barco": return new Barco(info);
		case "Aviao": return new Aviao(info);
		case "Carro": return new Carro(info);
		
		default: throw new IllegalArgumentException();
		}
	}
}