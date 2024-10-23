package semana05;

public class Time {
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

    public int getMin() {
        return min;
    }
    public int getSec() {
        return sec;
    }
    public int totalInSeconds(){
        return min * 60 + sec;
    }

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
    public String toString(){
        return min + " minutos e " + sec + " segundos";
    }
}
