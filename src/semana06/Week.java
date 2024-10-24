package semana06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Week {
    private List<String> days;

    public Week() {
        days = new ArrayList<>();
        //List<String> days = new ArrayList<>();
        days.add("MONDAY");
        days.add("TUESDAY");
        days.add("WEDNESDAY");
        days.add("THURSDAY");
        days.add("FRIDAY");
        //this.days = days;
    }

    public Iterator<String> iterator() {
        return new WeekDayIterator();
    }

        public static void main(String[] args) {
            Week week = new Week();
            //Iterator<String> it = week.getDays().iterator();
            Iterator<String> it = week.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        }

    private class WeekDayIterator implements Iterator<String> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < days.size();
        }

        @Override
        public String next() {
            return days.get(index++);
        }
    }

}