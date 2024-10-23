package semana04.pratica;

public class Empregados {
    private static final double SALARIO_BASE = 800.00;
    private static double salario;
    private int id;

    public Empregados(int id) {
        this.id = id;
        salario = SALARIO_BASE;
    }


    public double getSalario() {
        return salario;
    }

    public int getId() {
        return id;
    }

    public void setAumento(double bonus) {
        salario += bonus;
    }

    public String toString() {
        return id + " recebe " + getSalario() + " euros.";
    }
}
