package semana04.pratica;

public class Cliente {
    private String nome;
    private int id;
    protected double valorMedioCompras;

    public Cliente(String nome, int id, double valorMedioCompras) {
        this.nome = nome;
        this.id = id;
        this.valorMedioCompras = valorMedioCompras;
    }

    public String getNome() {
        return nome;
    }
    public int getId() {
        return id;
    }
    public double getValorMedioCompras() {
        return valorMedioCompras;
    }

    public double valorAPagarComDesconto(double valorAPagar) {
        return valorAPagar;
    };


}
