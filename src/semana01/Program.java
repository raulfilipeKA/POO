package semana1;
import static java.lang.System.out;
import static java.lang.System.setOut;

public class Program {
    public static void main(String[] args) {
        System.out.println("Bye-bye graphical interface");
        System.out.println(args[0]);
        printArgs(args);
        System.out.println(stringToInt(args[0]));


    }

    static int stringToInt(String str){
        if (!isInt(str)){throw new IllegalArgumentException();}
        char[] c= str.toCharArray();
        int a= c[str.length()-1] - '0';
            for(int i = 1; i<str.length(); i++){
                int pow = (int) (Math.pow(10, i)*(c[c.length-i-1]-'0'));
                a=a+pow;
            }return a+1;
    }



    static boolean isInt(String str){
        char[] c = str.toCharArray();
        for(int i = 0; i< c.length; i++){
            if(c[i] >= '0' && c[i]  <= '9'){return true;}
                else { return false;}
        }
        return false;
    }

    public static void printArgs(String[] str){
        if(str.length == 0) throw new IllegalArgumentException();
        for(int i = 0; i< str.length; i++){
            System.out.println(i + ": " + str[i]);
        }
    }
}
