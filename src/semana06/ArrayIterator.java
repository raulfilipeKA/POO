package semana06;
import semana06.sampleCode.Pessoa;

import java.util.Iterator;
public class ArrayIterator<T> implements Iterator<T> {

    private T[] array;
    private int index = 0;

    public ArrayIterator(T[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return this.index < this.array.length;
    }

    @Override
    public T next() {
        return this.array[this.index++];
    }

    public static void main(String[] args) {
        Pessoa[] pessoas = new Pessoa[]{
                new Pessoa("Ana", 60, 165),
                new Pessoa("Tomas", 70, 165),
                new Pessoa("Rita", 50, 160)
        };
        ArrayIterator<Pessoa> it = new ArrayIterator(pessoas);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
