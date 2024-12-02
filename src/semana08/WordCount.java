package semana08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordCount {
    //visa apenas contar as palavras diferentes
    Set<String> words = new HashSet<>();
    //HashMap<String, Integer> wordCount = new HashMap<>();

    public WordCount(String path) {
        try {
            File file = new File(path);
            Scanner sc = new Scanner(file, "UTF-8");
            sc.useDelimiter("[,\\.;:\\-\\?!»«\\(\\)0-9\\s]+");
            while (sc.hasNext()) {
                String word = sc.next();
                this.words.add(word.toLowerCase());
            }
        } catch (FileNotFoundException _) {
            System.out.println("AHAH");
        }
    }

    public static void main(String[] args) {
           WordCount wc = new WordCount("OsMaias-Cap1.txt");
           System.out.println("The file has " + wc.getWordCount() + " words.");

    }

    public int getWordCount(){
        return words.size();
    }

}
