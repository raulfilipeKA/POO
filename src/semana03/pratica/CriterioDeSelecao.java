package semana03.pratica;

public interface CriterioDeSelecao<T> {
    boolean cumpreOCriterio(T elemento);
}
