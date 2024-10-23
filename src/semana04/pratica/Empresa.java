package semana04.pratica;
import java.util.ArrayList;
import java.util.List;
public class Empresa {
    private List<Empregados> staff;
    private double totalSalarios;

    public Empresa(Empregados empregado) {
        staff = new ArrayList<Empregados>();
        totalSalarios = 0;
        staff.add(empregado);
    }

    public Empresa(List<Empregados> staff) {
        this.staff = staff;
        totalSalarios = 0;
        for(int i = 0; i < staff.size(); i++){
            totalSalarios += staff.get(i).getSalario();
        }
    }

    public void adicionaEmpregado(Empregados empregado) {
        staff.add(empregado);
        totalSalarios += empregado.getSalario();
    }

    public String toString() {
        return "A empresa tem " + staff.size() + " empregados e paga " + totalSalarios + " euros em salários.";
    }
}
