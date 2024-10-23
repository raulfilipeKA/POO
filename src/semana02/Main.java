package semana02;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<Aluno> alunos = Aluno.readAlunos("estudantes.txt");

        //for(Aluno a : alunos){
        //    System.out.println(a);
        //}
        Disciplina  disc = Disciplina.criarDisciplina("Inteligencia de Artificial", 200, alunos);
        System.out.println(disc);


    }
}
