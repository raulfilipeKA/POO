//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package semana06;

import java.util.Iterator;

public class Interval implements Iterable<Integer> {
    private int start;
    private int end;

    public Interval(int start, int end) {
        this.start = Math.min(start, end);
        this.end = Math.max(start, end);
    }

    public static Interval naturals(int n) {
        return new Interval(1, n);
    }

    public static Interval indexes(int[] v) {
        return new Interval(0, v.length - 1);
    }

    public static Interval empty() {
        return null;
    }

    public String toString() {
        return "[" + this.start + ", " + this.end + "]";
    }

    static double average(Iterable<Integer> iterable) {
        double sum = 0.0;
        int count = 0;

        for(Iterator var4 = iterable.iterator(); var4.hasNext(); ++count) {
            int i = (Integer)var4.next();
            sum += (double)i;
        }

        return sum / (double)count;
    }

    public Iterator<Integer> iterator() {
        return new IntervalIterator(this, this.start, this.end);
    }

    private class IntervalIterator implements Iterator<Integer> {
        private int current;
        private int end;

        public IntervalIterator(final Interval var1, int start, int end) {
            this.current = start;
            this.end = end;
        }

        public boolean hasNext() {
            return this.current <= this.end;
        }

        public Integer next() {
            return this.current++;
        }
    }
}
