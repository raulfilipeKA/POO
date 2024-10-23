package semana03.pratica;

import java.util.Comparator;

public class ComparadorAnoNascimento implements Comparator<Aluno> {

    @Override
    public int compare(Aluno a1, Aluno a2) {
        if(a2.getAnoNascimento() == a1.getAnoNascimento()){
            return a2.getAnoMatricula() - a1.getAnoMatricula();
        }
        if(a2.getAnoMatricula() == a1.getAnoMatricula()){
            return a2.getNumero() - a1.getNumero();
        }
        return String.CASE_INSENSITIVE_ORDER.compare(a1.getNome(), a2.getNome());
    }

}
