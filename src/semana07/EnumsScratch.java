package semana07;

public enum EnumsScratch {
    MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    public EnumsScratch nextDay() {
        if (this.equals(SUNDAY)) {
            return MONDAY;
        }
        //EnumsScratch[] days = values();
        EnumsScratch[] days = EnumsScratch.values();
        return days[this.ordinal() + 1];
    }

    public static void main(String[] args) {
        EnumsScratch day = EnumsScratch.SUNDAY;
        System.out.println(day);
        System.out.println(day.nextDay());
    }
}
