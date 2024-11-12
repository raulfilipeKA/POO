package semana07;

import java.sql.SQLOutput;

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
        EnumsScratch day = EnumsScratch.MONDAY;
        System.out.println(day.ordinal());
        System.out.println(day);
        System.out.println(day.nextDay());
        System.out.println(day);
    }
}
