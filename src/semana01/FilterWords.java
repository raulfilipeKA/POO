package semana1;

import java.util.Scanner;

public class FilterWords {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        String[] words = sentence.split(" ");



    }

    public static String[] filter(String[] args, String censored){
        String[] res = new String[wordCount(args, censored)];
        int atraso=0;
        for (int i = 0; i < args.length; i++) {
            if(!args[i].equals(censored)){ res[i-atraso] = args[i];}
            else atraso++;
        }
        return res;
    }

    public static int wordCount(String[] args, String censored){
        int count = 0;
        for (int i = 0; i <args.length ; i++) {
            if(args[i].equals(censored)){ count++;}
        }
        return count;
    }
}
