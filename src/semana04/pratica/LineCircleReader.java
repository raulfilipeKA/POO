package semana04.pratica;

import java.io.File;
import java.io.FileNotFoundException;

public class LineCircleReader extends LineObjectReader<Circle> {
    

        public LineCircleReader(File file) throws FileNotFoundException {
            super(file);
            read();
        }

        @Override
        public Circle lineToObject(String line) {
            String[] parts = line.split(";");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            int raio = Integer.parseInt(parts[2]);
            return new Circle(x, y, raio);
        }
    
}
