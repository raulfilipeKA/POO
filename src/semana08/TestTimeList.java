package semana08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestTimeList {

    public static void main(String[] args) {
        List<Time> list = new ArrayList<>();
        Time t1 = new Time(1, 30);
        Time t2 = new Time(2, 30);
        Time t3 = new Time(1, 0);
        list.add(t1);
        list.add(t2);
        list.add(t3);
        //list.sort(null);
        Collections.sort(list);
        for(Time t : list){
            System.out.println(t);
        }
        System.out.println("Reverse order");
        list.sort(Collections.reverseOrder());
        for(Time t : list){
            System.out.println(t);
        }
    }
}
