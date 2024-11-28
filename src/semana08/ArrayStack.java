package semana08;

import java.util.ArrayList;

public class ArrayStack<T> implements Stack<T> {
    private ArrayList<T> stack;
    private int size;

    public ArrayStack() {
        stack = new ArrayList<>();
        size = 0;
    }

    @Override
    public void push(T elem) {
        stack.add(elem);
        size++;
    }

    @Override
    public T peek() {return stack.get(size - 1);}

    @Override
    public T pop() {
        T elem = stack.get(size - 1);
        stack.remove(size - 1);
        size--;
        return elem;
    }

    @Override
    public int size() {return size;}

    @Override
    public boolean isEmpty() {return size == 0;}
}
