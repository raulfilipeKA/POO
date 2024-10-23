package semana04.pratica;

public class Gerente extends Empregados {
    private double BONUS = 200.0;

    public Gerente(int id, boolean bonus) {
        super(id);
        if (bonus) {
            super.setAumento(super.getSalario() + BONUS);
        }
    }

    public double getSalario() {
        return super.getSalario() + BONUS;
    }


    public String toString() {
        return super.getId() + " recebe " + getSalario() + " euros.";
    }
}
