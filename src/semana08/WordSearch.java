package semana08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class WordSearch {
    SortedSet<String> asc = new TreeSet<>();
    SortedSet<String> subSet;


    WordSearch(String path, String a, String b)throws FileNotFoundException {
        File file = new File(path);
        Scanner sc = new Scanner(file, "UTF-8");
        sc.useDelimiter("[,\\.;:\\-\\?!»«\\(\\)0-9\\s]+");
        while(sc.hasNext()){
            String word = sc.next();
            this.asc.add(word.toLowerCase());
        }
        if (!(asc.contains(a.toLowerCase()) && asc.contains(b.toLowerCase()))) {
            throw new IllegalArgumentException("One or both words are not in the file");
        }
        if(a.compareTo(b) > 0){
            subSet = asc.subSet(b.toLowerCase(), a.toLowerCase());
        }
        else {
            subSet = asc.subSet(a.toLowerCase(), b.toLowerCase());
        }
    }

    public int getWordCount(){
        return subSet.size();
    }
    SortedSet<String> getInterval(){
        return subSet;
    }

    public static void main(String[] args) throws FileNotFoundException {
        WordSearch ws = new WordSearch("OsMaias-Cap1.txt", "lisboa", "livre");
        SortedSet<String> interval = ws.getInterval();
        System.out.println("The file has " + ws.getWordCount()  + " words.");
        for(String word : interval){
            System.out.println(word);
        }
    }



}
