package semana03.pratica;

import java.util.Comparator;

public class ComparadorNome implements Comparator<Aluno> {

    @Override
    public int compare(Aluno a1, Aluno a2) {
       Comparator<String> comp = String.CASE_INSENSITIVE_ORDER;
       return comp.compare(a1.getNome(), a2.getNome());
       //return String.CASE_INSENSITIVE_ORDER.compare(a1.getNome(), a2.getNome());
    }
}
