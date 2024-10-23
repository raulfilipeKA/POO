package semana05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Album {
    private String name;
    private int year;
    private List<String> artists;
    private List<Song> songs;

    public Album(String name, int year, List<String> artists, List<Song> songs){
        this.name = name;
        this.year = year;
        this.artists = artists;
        this.songs = songs;
    }

    public Album(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        this.name = sc.nextLine();
        this.year = Integer.parseInt(sc.nextLine());
        List<String> artists = new ArrayList<>();
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            System.out.println(line);
            if(line.equals("")){
                //System.out.println(line);
                break;
            }
            artists.add(line);
        }
        int trackNumber = 1;
        int min;
        int sec;
        List<Song> songs = new ArrayList<>();
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            System.out.println(line);
            String[] parts = line.split(":");
            min = Integer.parseInt(parts[0]);
            String[] str = parts[1].split(" ");
            str = parts[1].split(" ");
            sec = Integer.parseInt(str[0]);
            String song= str[1];
            for(int i = 2; i < str.length; i++){
                song += (" " +str[i]);
            }
            Time duration = new Time(min, sec);
            songs.add(new Song(song, duration, trackNumber));
            trackNumber++;
        }
        this.artists = artists;
        this.songs = songs;
    }

    public String getName() {
        return name;
    }
    public int getYear() {
        return year;
    }

    public ArrayList<Song> getSongs() {
        return (ArrayList<Song>) songs;
    }
    public Time albumDuration(){
        Time total = new Time(0, 0);
        for(Song song : songs){
            total = total.add(song.getDuration());
        }
        return total;
    }
    @Override
    public String toString(){
        return name + ", " + year;
    }

    public static class Song {
        protected String name;
        protected Time duration;
        protected int trackNumber;

        public Song(String name, Time duration, int trackNumber) {
            this.name = name;
            this.duration = duration;
            this.trackNumber = trackNumber;
        }

        public String getName() {
            return name;
        }

        public Time getDuration() {
            return duration;
        }

        public int getTrackNumber() {
            return trackNumber;
        }

        @Override
        public String toString() {
            return name + " - " + duration + " - " + trackNumber;
        }
    }
}
