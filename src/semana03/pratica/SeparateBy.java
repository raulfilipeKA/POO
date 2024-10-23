package semana03.pratica;

import java.util.ArrayList;
import java.util.Arrays;

public class SeparateBy {
    private String str;


    public SeparateBy(String[] words, String separator) {

        String str = "";
        for (String word : words) {
            if(word.equals(words[words.length-1])){
                str += word;
                break;
            }
            str += word + separator;
        }this.str = str;
    }

        public SeparateBy(ArrayList<String> words, String separator) {

            String str = "";
            for (String word : words) {
                if(word.equals(words.get(words.size()-1))){
                    str += word;
                    break;
                }
                str += word + separator;
            }

            this.str = str;
        }

    @Override
    public String toString() {
        return str;
    }
}
