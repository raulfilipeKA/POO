package semana08;

import java.util.PriorityQueue;
public class TestTimePriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Time> queue = new PriorityQueue<>();
        Time t1 = new Time(1, 30);
        Time t2 = new Time(2, 30);
        Time t3 = new Time(1, 2);
        queue.offer(t1);
        queue.add(t2);
        queue.add(t3);
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
