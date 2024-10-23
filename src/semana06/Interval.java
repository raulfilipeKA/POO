package semana06;

import java.util.Iterator;

public class Interval implements Iterable<Integer>{
    private int start;
    private int end;

    public Interval(int start, int end){
        this.start = Math.min(start, end);
        this.end = Math.max(start, end);
    }


    public static Interval naturals(int n){
        return new Interval(1, n);
    }

    public static Interval indexes(int[] v){
        return new Interval(0, v.length-1);
    }
    public static Interval empty(){
        return null;
    }

    @Override
    public String toString(){
        return "[" + start + ", " + end + "]";
    }

    static double average(Iterable<Integer> iterable){
        double sum = 0;
        int count = 0;
        for (int i : iterable){
            sum += i;
            count++;
        }
        return sum / count;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new IntervalIterator(start, end);
    }

    private class IntervalIterator implements Iterator<Integer>{
        private int current;
        private int end;

        public IntervalIterator(int start, int end){
            this.current = start;
            this.end = end;
        }

        @Override
        public boolean hasNext(){
            return current <= end;
        }

        @Override
        public Integer next(){
            return current++;
        }
    }
}
