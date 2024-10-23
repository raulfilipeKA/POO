package semana04.pratica;

import java.io.File;
import java.io.FileNotFoundException;

public class TesteCirculos {

    public static void main(String[] args) throws FileNotFoundException {
        LineCircleReader reader = new LineCircleReader(new File("C:\\Users\\raulf\\.intellijava\\POO\\src\\semana04\\pratica\\Circulos.txt"));
        for (Circle c : reader.read()) {
            System.out.println(c);
        }

    }
}
