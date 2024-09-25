package semana02;

import org.w3c.dom.ls.LSOutput;

public class Teste {
    //criar classe teste de aluno
    public static void main(String[] args) {
        Aluno a1 = new Aluno("Zé", 111);
        Aluno a2 = new Aluno("Ana", 222);
        Aluno a3 = new Aluno("Rui", 333);
        Aluno a4 = new Aluno("Ines", 444);

        Disciplina poo = new Disciplina("POOnome", "POO", 3);
        poo.inscrever(a1);
        poo.inscrever(a2);
        poo.inscrever(a3);
        poo.inscrever(a4);
        System.out.println();

        Disciplina bd = new Disciplina("BDnome", "BD", 4);
        bd.inscrever(a4);
        bd.inscrever(a1);
        System.out.println(bd);


    }
}
