package semana08;

import java.util.List;

public class Time implements Comparable<Time> {
    private int min;
    private int sec;

    public Time(int min, int sec){
        if(min < 0 || sec < 0){
            throw new IllegalArgumentException("Invalid time");
        }
        this.min = min;
        this.sec = sec;
    }

    public Time(String time){
        String[] parts = time.split(":");
        if(parts.length != 2){
            throw new IllegalArgumentException("Invalid time");
        }
        int min = Integer.parseInt(parts[0]);
        int sec = Integer.parseInt(parts[1]);
        if(min < 0 || sec < 0){
            throw new IllegalArgumentException("Invalid time");
        }
        this.min = min;
        this.sec = sec;
    }

    @Override
    public int hashCode(){return min * 60 + sec;}
    @Override
    public boolean equals(Object obj){
//        if(this == obj) return true;
//        if(obj == null || getClass() != obj.getClass()) return false;
//        return this.hashCode() == obj.hashCode();
        return obj != null && obj instanceof Time && this.hashCode() == obj.hashCode();
    }

    public int getMin() {return min;}
    public int getSec() {return sec;}
    public int totalInSeconds(){return min * 60 + sec;}

    public Time add(Time time){
        int totalMinutes = min + time.getMin();
        int totalSeconds = sec + time.getSec();
        return new Time(totalMinutes, totalSeconds);
    }
    public Time subtract(Time time){
        int totalMinutes = min - time.getMin();
        int totalSeconds = sec - time.getSec();
        return new Time(totalMinutes, totalSeconds);
    }
    public boolean isGreaterThan(Time time){
        return totalInSeconds() > time.totalInSeconds();
    }
    public boolean isLessThan(Time time){
        return totalInSeconds() < time.totalInSeconds();
    }

    @Override
    public String toString(){return min + " minutos e " + sec + " segundos";}

    @Override
    public int compareTo(Time o) {return totalInSeconds() - o.totalInSeconds();}

    public static void main(String[] args){
        Time t1 = new Time(1, 30);
        Time t2 = new Time(1, 30);
        Time t3 = new Time(1, 60);
        Time t4 = new Time(2, 0);
        Time t5 = new Time(0, 30);
        Time t6 = new Time(0, 45);
        Time t7 = new Time(0, 45);
        System.out.println(t1.equals(t2)); // true
        System.out.println(t1.equals(t3)); // false
        System.out.println(t3.equals(t4)); // false
        System.out.println(t1.equals(t5)); // false
        System.out.println(t1.equals(t6)); // false
        System.out.println(t6.equals(t7)); // true
        boolean hash1 = t1.hashCode() == t2.hashCode();
        System.out.println("hash: " + hash1); // true
        boolean hash2 = t1.hashCode() == t3.hashCode();
        System.out.println("hash: " + hash2); // false
        List<Time> times = List.of(t1, t2, t3, t4, t5, t6, t7);
        boolean b = times.contains(new Time(1, 30));
        System.out.println(b); // true
    }



}
