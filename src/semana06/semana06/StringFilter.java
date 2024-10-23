//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package semana06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class StringFilter {
    public StringFilter() {
    }

    static Iterable<String> select(Iterable<String> iterable, Predicate<String> predicate) {
        List<String> list = new ArrayList();
        Iterator var3 = iterable.iterator();

        while(var3.hasNext()) {
            String s = (String)var3.next();
            if (predicate.test(s)) {
                list.add(s);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        List<String> iterable = List.of("a", "", "b", "");
        Iterable<String> nonEmpty = select(iterable, (sx) -> {
            return !sx.isEmpty();
        });
        Iterator var3 = nonEmpty.iterator();

        while(var3.hasNext()) {
            String s = (String)var3.next();
            System.out.println(s);
        }

        Iterable<String> nonEmpty2 = select(iterable, (sx) -> {
            return sx.length() > 0;
        });
        System.out.println(nonEmpty2);
    }
}
