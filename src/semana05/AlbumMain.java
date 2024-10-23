package semana05;
import java.io.File;
import java.io.FileNotFoundException;

public class AlbumMain {
    public static void main(String[] args){

        try {
            Album album = new Album( new File ("C:\\Users\\raulf\\.intellijava\\POO\\src\\semana05\\txt"));
            for(Album.Song song : album.getSongs()){
                System.out.println(song);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
