package semana03.pratica;
import java.util.ArrayList;
public class FilterWords implements CriterioDeSelecao<String> {

    private String prefix;

    public FilterWords(String prefix){
        this.prefix = prefix;
    }

    @Override
    public boolean cumpreOCriterio(String str) {
        return str.startsWith(prefix);
    }

}
