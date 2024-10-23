package semana04.teorica;

public class Gerente extends Funcionario {

    public Gerente(String nome, int id) {
        super(nome, id);

    }

    @Override
    public double getSalario() {
        return super.getSalario()*1.5;
    }
}
