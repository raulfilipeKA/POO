package semana08;

public interface Stack<E> {
    void push(E elem);
    E peek();
    E pop();
    int size();
    boolean isEmpty();
}
