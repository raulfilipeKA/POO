package semana03.pratica;

import java.util.Comparator;

public class ComparadorCrescentePorNumero implements Comparator<Aluno> {

    @Override
    public int compare(Aluno a1, Aluno a2) {
        return a1.getNumero() - a2.getNumero();
    }
}
