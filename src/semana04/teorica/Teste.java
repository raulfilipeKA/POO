package semana04.teorica;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Teste {

    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();
        Object a = new int[5];
        funcionarios.add(new Funcionario("João", 1));
        funcionarios.add(new Gerente("Maria", 2));
        funcionarios.add(new Diretor("José", 3, "TI"));

        for(Funcionario f : funcionarios) {
            System.out.println(f);
        }
    }

}
