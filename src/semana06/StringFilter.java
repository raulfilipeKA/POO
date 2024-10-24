package semana06;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StringFilter {

    static Iterable<String> select(Iterable<String> iterable, Predicate<String> predicate){
        List<String> list = new ArrayList<>();
        for(String s : iterable){
            if(predicate.test(s)){
                list.add(s);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> iterable = List.of("a", "", "b", ""); //funciona porque List implementa a interface Iterable
        Iterable<String> nonEmpty = select(iterable, s -> !s.isEmpty());
        for(String s : nonEmpty){
            System.out.println(s);
        }
        Iterable<String> nonEmpty2 = select(iterable, s -> s.length() > 0);
        System.out.println(nonEmpty2);

    }
}
