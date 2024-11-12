package testeExIntercalar;

import java.util.Date;
import java.util.Comparator;

public class Cenas implements Comparator<Date> {

    @Override
    public int compare(Date o1, Date o2) {
        if(isBefore(o1, o2)){
            return -1;
        }
        if(isBefore(o2, o1)){
            return 1;
        }
        return 0;
    }

    public static boolean isBefore(Date d1, Date d2){
        if(d1.getYear() < d2.getYear()){
            return true;
        }
        if(d1.getMonth() < d2.getMonth()){
            return true;
        }
        if(d1.getDate() < d2.getDate()){
            return true;
        }
        return false;
    }
}
//ou fazer simplesmente:
//@Override
//public int compare(Date o1, Date o2){
//    return o1.compareTo(o2);
//}