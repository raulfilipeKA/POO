//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package semana06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import semana06.sampleCode.Pessoa;

public class GenericFilter {
    public GenericFilter() {
    }

    static <T> Iterable<T> select(Iterable<T> iterable, Predicate<T> predicate) {
        List<T> list = new ArrayList();
        Iterator var3 = iterable.iterator();

        while(var3.hasNext()) {
            T s = var3.next();
            if (predicate.test(s)) {
                list.add(s);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        List<Pessoa> iterable = List.of(new Pessoa("Ana", 60, 165), new Pessoa("Tomas", 70, 165), new Pessoa("Rita", 50, 160), new Pessoa("Bruno", 80, 180), new Pessoa("Joana", 55, 160), new Pessoa("Guilherme", 75, 170), new Pessoa("Vitor", 80, 185), new Pessoa("Pedro", 70, 170), new Pessoa("Vasco", 50, 175));
        Iterable<Pessoa> result = select(iterable, (p) -> {
            return p.getPeso() > 65;
        });
        result.forEach((p) -> {
            System.out.println(p);
        });
    }
}
