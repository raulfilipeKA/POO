//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package semana06.sampleCode;

import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T> {
    private T[] array;
    private int index = 0;

    public ArrayIterator(T[] array) {
        this.array = array;
    }

    public boolean hasNext() {
        return this.index < this.array.length;
    }

    public T next() {
        return this.array[this.index++];
    }

    public static void main(String[] args) {
        Pessoa[] pessoas = new Pessoa[]{new Pessoa("Ana", 60, 165), new Pessoa("Tomas", 70, 165), new Pessoa("Rita", 50, 160)};
        ArrayIterator<Pessoa> it = new ArrayIterator(pessoas);

        while(it.hasNext()) {
            System.out.println(it.next());
        }

    }
}
