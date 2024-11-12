package semana05;
import semana03.pratica.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparadordeAlunos2 {
    public static void main(String[] args) {
        Aluno a1 = new Aluno(120, "João", 2021, 2011);
        Aluno a2 = new Aluno(121, "Aaria", 2022, 1998);
        Aluno a3 = new Aluno(122, "PEdro", 2020, 2004);
        Aluno a4 = new Aluno(123, "ANa", 2020, 2008);
        Aluno a5 = new Aluno(124, "Rita", 2015, 1999);

        List<Aluno> alunos = new ArrayList<>();
        alunos.add(a1);
        alunos.add(a2);
        alunos.add(a3);
        alunos.add(a4);
        alunos.add(a5);
        System.out.println("--------Ordenando por numero--------");
        alunos.sort((aluno1, aluno2) -> aluno1.getNumero() - aluno2.getNumero());
        for (Aluno a : alunos) {
            System.out.println(a);
        }
        System.out.println("--------Ordenando por nome--------");
        alunos.sort(new Comparator<Aluno>(){
            @Override
            public int compare(Aluno o1, Aluno o2){
                return o1.getNome().compareTo(o2.getNome()); // case sensitive
            }
        });
        for (Aluno a : alunos) {
            System.out.println(a);
        }
        System.out.println("--------Ordenando por nome1--------");


        alunos.sort((o1, o2) -> {return o1.getNome().compareTo(o2.getNome());});
        alunos.sort((o1, o2) -> o1.getNome().compareTo(o2.getNome()));

        alunos.sort(new Comparator<Aluno>(){
            @Override
            public int compare(Aluno o1, Aluno o2){
                Comparator<String> comp = String.CASE_INSENSITIVE_ORDER;
                return comp.compare(o1.getNome(), o2.getNome());
            }
        });
        for (Aluno a : alunos) {
            System.out.println(a);
        }
        System.out.println("--------DECRESCENTE por ano de nascimento--------");
        alunos.sort(new Comparator<Aluno>(){
            @Override
            public int compare(Aluno a1, Aluno a2){
            if(a2.getAnoNascimento() == a1.getAnoNascimento()){
                return a2.getAnoMatricula() - a1.getAnoMatricula();
            }
            if(a2.getAnoMatricula() == a1.getAnoMatricula()){
                return a2.getNumero() - a1.getNumero();
            }
            return String.CASE_INSENSITIVE_ORDER.compare(a1.getNome(), a2.getNome());
            }
        });
        for (Aluno a : alunos) {
            System.out.println(a);
        }
        System.out.println("--------Ordenando por UOHIGHIUGIUGUGIU--------");
        alunos.sort((ao1, ao2) -> {
            if (ao2.getAnoNascimento() == ao1.getAnoNascimento()) {
                return ao2.getAnoMatricula() - ao1.getAnoMatricula();
            }
            if (ao2.getAnoMatricula() == ao1.getAnoMatricula()) {
                return ao2.getNumero() - ao1.getNumero();
            }
            return String.CASE_INSENSITIVE_ORDER.compare(ao1.getNome(), ao2.getNome());
        });
        for (Aluno a : alunos) {
            System.out.println(a);
        }
    }
}
