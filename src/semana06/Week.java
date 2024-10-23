//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package semana06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Week {
    private List<String> days = new ArrayList();

    public Week() {
        this.days.add("MONDAY");
        this.days.add("TUESDAY");
        this.days.add("WEDNESDAY");
        this.days.add("THURSDAY");
        this.days.add("FRIDAY");
    }

    List<String> getDays() {
        return this.days;
    }

    public Iterator<String> iterator() {
        return new WeekDayIterator();
    }

    public static void main(String[] args) {
        Week week = new Week();
        Iterator<String> it = week.iterator();

        while(it.hasNext()) {
            System.out.println((String)it.next());
        }

    }

    private class WeekDayIterator implements Iterator<String> {
        private int index = 0;

        private WeekDayIterator() {
        }

        public boolean hasNext() {
            return this.index < Week.this.days.size();
        }

        public String next() {
            return (String)Week.this.days.get(this.index++);
        }
    }
}
