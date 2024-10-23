package semana04.pratica;

public class Diretor extends Empregados{
    private double lucroMensal;

    public Diretor(int id, double lucroMensal) {
        super(id);
        this.lucroMensal = lucroMensal;
    }

    public double getSalario() {
        return super.getSalario()*2+0.01*lucroMensal;
    }
}
