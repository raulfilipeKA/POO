package semana03.pratica;

import java.util.ArrayList;

public class FilterSmallWords implements CriterioDeSelecao<String>{
    private int size;

    public FilterSmallWords(int size){
        this.size = size;
    }

    @Override
    public boolean cumpreOCriterio(String str) {
        return str.length() < size;

    }
}
