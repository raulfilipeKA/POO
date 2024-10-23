package semana06.sampleCode;

import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T> {
    private T[] array;
    private int index = 0;

    public ArrayIterator(T[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return index < array.length;
    }

    @Override
    public T next() {
        return array[index++];
    }

    public static void main(String[] args){
        Pessoa[] pessoas = new Pessoa[3];
        pessoas[0] = new Pessoa("Ana", 60, 165);
        pessoas[1] = new Pessoa("Tomas", 70, 165);
        pessoas[2] = new Pessoa("Rita", 50, 160);
        ArrayIterator<Pessoa> it = new ArrayIterator<>(pessoas);
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}
