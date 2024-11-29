package semana08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordCountInterval {
    Map<String, Integer> wordCount = new TreeMap<>();
    Map<String, Integer> subSet = new TreeMap<>();

    public WordCountInterval(String path, String start, String end) {
        try {
            File file = new File(path);
            Scanner sc = new Scanner(file, "UTF-8");
            sc.useDelimiter("[,\\.;:\\-\\?!»«\\(\\)0-9\\s]+");
            while (sc.hasNext()) {
                String word = sc.next();
                wordCount.put(word.toLowerCase(), wordCount.getOrDefault(word.toLowerCase(), 0) + 1);

            }


        } catch (FileNotFoundException _) {
            System.out.println("Stuff");
        }
    }

    public void createSubSet(){
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getKey().compareTo("lisboa") >= 0 && entry.getKey().compareTo("livre") < 0) {
                subSet.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        WordCountInterval wc = new WordCountInterval("OsMaias-Cap1.txt", "lisboa", "livre");
        wc.createSubSet();
        for (Map.Entry<String, Integer> entry : wc.subSet.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }


}
