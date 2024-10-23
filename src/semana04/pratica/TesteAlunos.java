package semana04.pratica;

import semana02.Aluno;

import java.io.File;
import java.io.FileNotFoundException;

public class TesteAlunos{
    public static void main(String[] args) throws FileNotFoundException {
        LineStudentReader reader = new LineStudentReader(new File("C:\\Users\\raulf\\.intellijava\\POO\\src\\semana04\\pratica\\Alunos.txt"));
        for (Aluno aluno : reader.read()) {
            System.out.println(aluno);
        }
        System.out.println("Fim");
        for (Aluno aluno : reader.read()) {
            System.out.println(aluno.getNumero() + " - " + aluno.getNome());
        }
    }
}
