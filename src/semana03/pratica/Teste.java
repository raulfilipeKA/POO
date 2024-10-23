package semana03.pratica;

import java.util.ArrayList;
import java.util.Comparator;

public class Teste {
    public static void main(String[] args ){
        Aluno a1 = new Aluno(123, "Pedro", 2022, 2000);
        Aluno a2 = new Aluno(234, "Rita", 1999, 1990);
        Aluno a3 = new Aluno(345, "Joao", 1991, 1982);
        Aluno a4 = new Aluno(456, "Ana", 1999, 1982);

        ArrayList<Aluno> alunos = new ArrayList<>();

        alunos.add(a1);
        alunos.add(a2);
        alunos.add(a3);
        alunos.add(a4);

        System.out.println("Ordenando por numero");
        Comparator c = new ComparadorCrescentePorNumero();
        alunos.sort(c);
        for(Aluno a : alunos){
            System.out.println(a);
        }

        System.out.println("-------------------");
        System.out.println("Ordenando por nome");

        Comparator c2 = new ComparadorNome();
        alunos.sort(c2);
        for(Aluno a : alunos){
            System.out.println(a);
        }

        System.out.println("-------------------");
        System.out.println("Ordenando por ano de nascimento e depois matricula");

        Comparator c3 = new ComparadorAnoNascimento();
        alunos.sort(c3);

        for(Aluno a : alunos){
            System.out.println(a);
        }
    }
}
