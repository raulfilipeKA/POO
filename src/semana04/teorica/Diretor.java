package semana04.teorica;

public class Diretor extends Funcionario {
    private String departamento;

    public Diretor(String nome, int id, String departamento) {
        super(nome, id);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String toString(){
        return super.toString() + " Dep: " + departamento;
    }

    //@Override
    public double getSalario() {
        return super.getSalario()*2;
    }

}
