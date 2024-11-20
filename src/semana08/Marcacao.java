package semana08;

import semana08.Aluno;

public class Marcacao extends Aluno implements Comparable<Marcacao> {
    protected boolean marcacao;
    public Marcacao(Aluno a, boolean marcacao) {
        super(a);
        this.marcacao = marcacao;
    }
    boolean temMarcacao() {return marcacao;}
//       @Override
//         public int compare(Marcacao m1, Marcacao m2) {
//              if (m1.marcacao && m2.marcacao) {return 0;}
//              else if (m1.marcacao) {return -1;}
//              else if (m2.marcacao) {return 1;}
//              else {return m1.getNumero() - m2.getNumero();}
//         }

       @Override
         public int compareTo(Marcacao m) {
           if (this.marcacao && m.marcacao) {return 0;}
           else if (this.marcacao) {return -1;}
           else if (m.marcacao) {return 1;}
           //senao chama o comparador do Aluno
           //else {return this.getNumero() - m.getNumero();}
           else {return Integer.compare(this.getNumero(), m.getNumero());}
       }

//    @Override
//    public int compareTo(Marcacao m) {
//        // Primeiro, garante que alunos com marcação têm prioridade
//        if (this.marcacao && !m.marcacao) return -1;  // this tem marcação, vem antes
//        if (!this.marcacao && m.marcacao) return 1;   // m tem marcação, vem antes
//
//        // Se ambos têm ou não têm marcação, ordena pelo número
//        return Integer.compare(this.getNumero(), m.getNumero());
//    }


    @Override
    public String toString() {
        return super.toString() + (temMarcacao() ? " com marcacao" : " sem marcacao");
    }


}