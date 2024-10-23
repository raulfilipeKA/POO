package semana04.pratica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class LineObjectReader<T> {
    private File file;
    private ArrayList<T> list;

    public LineObjectReader(File file) {
        this.file = file;
    }

    public List<T> read() throws FileNotFoundException{
        Scanner sc = new Scanner(file);
        list = new ArrayList<>();
        while (sc.hasNextLine()) {
            T obj = lineToObject(sc.nextLine());
            list.add(obj);
        }
        sc.close();
        return list;
    }

    public abstract T lineToObject(String line);


}
