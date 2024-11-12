package testeExIntercalar;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ObjExplorer<T> {
    private File file;

    public ObjExplorer(File file) {
        this.file = file;
    }

    public void export(List<T> list, ObjToLine<T> o1) throws IOException {
        PrintWriter pw = new PrintWriter(file);
        list.forEach(t -> pw.println(o1.toLine(t)));

    }
}
