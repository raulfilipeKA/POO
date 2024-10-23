package semana04.teorica;

public class Funcionario {
    private String nome;
    private static double SALARIO_BASE = 820.00;
    private int id;

    public Funcionario(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return SALARIO_BASE;
    }

    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSalario(double salario) {
        SALARIO_BASE = salario;
    }

    public String toString() {
        return nome + " (" + id + "): " + getSalario() + "euros";
    }
}
