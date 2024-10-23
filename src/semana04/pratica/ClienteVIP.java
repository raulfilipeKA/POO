package semana04.pratica;

public class ClienteVIP extends Cliente{
    private double desconto;
    protected static final double VALOR_ALVO = 1500;

    public ClienteVIP(String nome, int id, double valorMedioCompras, double desconto) {
        super(nome, id, valorMedioCompras);
        this.desconto = desconto;
    }

    public double setDesconto(double desconto) {
        return this.desconto = desconto;
    }

    @Override
    public double valorAPagarComDesconto(double valorAPagar) {
        if (super.valorMedioCompras > VALOR_ALVO) {
            return valorAPagar - valorAPagar * (desconto / 100);
        }
        return super.valorMedioCompras;
    }
}
