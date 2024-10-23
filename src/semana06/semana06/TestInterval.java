//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package semana06;

import java.util.Iterator;

public class TestInterval {
    public TestInterval() {
    }

    public static void main(String[] args) {
        Interval interval = new Interval(1, 10);
        System.out.println(interval);
        System.out.println(Interval.naturals(10));
        System.out.println(Interval.indexes(new int[]{1, 2, 3, 4, 5}));
        System.out.println(Interval.empty());
        System.out.println(Interval.average(new Interval(2, 10)));
        System.out.println("D)");
        Interval test = new Interval(5, 7);
        Iterator var3 = test.iterator();

        while(var3.hasNext()) {
            Integer i = (Integer)var3.next();
            System.out.println(i);
        }

        System.out.println("Integer or int");
        var3 = test.iterator();

        while(var3.hasNext()) {
            int i = (Integer)var3.next();
            System.out.println(i);
        }

    }
}
