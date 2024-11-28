package semana08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordCountAndSearch {
    Map<String, Integer> wordCount = new HashMap<>();
    Map<String, Integer> topNSearch = new HashMap<>();

    public WordCountAndSearch(File file, int minWordLength, int topN) {
        try {
            Scanner sc = new Scanner(file, "UTF-8");
            sc.useDelimiter("[,\\.;:\\-\\?!»«\\(\\)0-9\\s]+");
            while (sc.hasNext()) {
                String word = sc.next();
                if (word.length() >= minWordLength) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
            topNWords(topN);
        } catch (  FileNotFoundException _) {
            System.out.println("Ficheiro não encontrado");
        }
    }

    public WordCountAndSearch(String path , String firstWord, String lastWord){
        try {
            WordSearch ws = new WordSearch("OsMaias-Cap1.txt", "lisboa", "livre");
            SortedSet<String> interval = ws.getInterval();
            for(String word : interval){

            }

        } catch (  FileNotFoundException _) {
            System.out.println("Ficheiro não encontrado");
        }
    }


    public void topNWords(int topN){
        for (int i = 0; i < topN; i++) {
            int max = 0;
            String word = "";
            for (String w : wordCount.keySet()) {
                if (wordCount.get(w) > max) {
                    max = wordCount.get(w);
                    word = w;
                }
            }
            topNSearch.put(word, max);
            wordCount.remove(word);
        }
    }


    public int getWordCount(String word) {
        return topNSearch.get(word);
    }

    public static void main(String[] args) throws FileNotFoundException {
        WordCountAndSearch wc = new WordCountAndSearch(new File("OsMaias-Cap1.txt"), 5, 7);
//        for(String word : wc.topNSearch.keySet()){
//            System.out.println(word + " " + wc.getWordCount(word));
//        }
        System.out.println("---------------------------");

        WordCountAndSearch clone = new WordCountAndSearch(new File("OsMaias-Cap1.txt"), 5, 7);
        for (int i = 0; i < 7; i++) {
            int max = 0;
            String w = "";
            for(String word : clone.topNSearch.keySet()){
                if(clone.topNSearch.get(word) > max){
                    max = clone.topNSearch.get(word);
                    w = word;
                }
            }
            System.out.println(w + " " + max);
            clone.topNSearch.remove(w);

        }

    }



}
