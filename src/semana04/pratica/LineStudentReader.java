package semana04.pratica;
import semana02.Aluno;

import java.io.File;
import java.io.FileNotFoundException;


public class LineStudentReader extends LineObjectReader<Aluno> {

    public LineStudentReader(File file) throws FileNotFoundException {
        super(file);
        read();
    }

    @Override
    public Aluno lineToObject(String line) {
        String[] parts = line.split(";");
        String num = parts[0];
        String nome = parts[1];
        return new Aluno(nome, Integer.parseInt(num));
    }


}
