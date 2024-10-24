package semana06;

public class TestInterval {
    public static void main(String[] args) {
        Interval interval = new Interval(1, 10);
        System.out.println(interval);
        System.out.println(Interval.naturals(10));
        System.out.println(Interval.indexes(new int[]{1, 2, 3, 4, 5}));
        System.out.println(Interval.empty());

        System.out.println(Interval.average(new Interval(2, 10)));
        System.out.println("D)");
        Interval test = new Interval(5, 7);
        for(Integer i : test){
            System.out.println(i);
        }
        System.out.println("Integer or int");
        for(int i : test){
            System.out.println(i);
        }



    }

}
