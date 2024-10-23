package semana04.pratica;
import java.util.ArrayList;

public class TesteEmpregados {
    public static void main(String[] args) {
        //cria me 5 empregados, dois deles gerentes
        Empregados empregado1 = new Empregados(1);
        Empregados empregado2 = new Empregados(2);
        Empregados empregado3 = new Empregados(3);
        Empregados empregado4 = new Gerente(4, true);
        Empregados empregado5 = new Gerente(5, false);

       ArrayList<Empregados> staff = new ArrayList<Empregados>();
       staff.add(empregado1);
       staff.add(empregado2);
       staff.add(empregado3);
       staff.add(empregado4);
       staff.add(empregado5);
       staff.add(new Diretor(6, 80000.0));

       for(Empregados empregado : staff){
           System.out.println(empregado);
       }
        Empresa empresa = new Empresa(staff);
        System.out.println(empresa);


    }
}
