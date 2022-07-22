package com.uce.musicplayer.music;

import com.uce.musicplayer.model.Data;
import com.uce.musicplayer.rstructure.List;
import com.uce.musicplayer.rstructure.Node;
import com.uce.musicplayer.syspropriety.Os;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;


public class Music {
    private static int counter = 0;


    private Song song;
    private int id;

    public static List allSongs = new List();
    public static List PlayQueue = new List();
    public static List Favourites = new List();
    public static List MostPlayed = new List();
    public static List NewlyAdded = new List();
    public static List RecentlyPlayed = new List();


    public Music(Song song){
        this.song = song;
        this.id = counter++;
        counter++;
    }

    public Music(int id, Song song){
        this.song = song;
        this.id = id;
        counter++;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void updateDatabase(){
        Data data = new Data(convertSongMusic());
        data.updateDatabase();
    }

    public static ArrayList<Music> startupData(){
        Data data = new Data(convertSongMusic());
        return data.startUpData();
    }

    private static ArrayList<Music> convertSongMusic(){

        //updateSongs();
        ArrayList<Music> musics = new ArrayList<>();
        Node aux = allSongs.getBeginning();
        while(aux != null){
            musics.add(new Music((Song)aux.getData()));
            aux = aux.getNext();
        }
        return musics;
    }


    public static void updateSongs(){
//        new Thread(new Runnable() {
//            @Override
//            public void run() {


        File dir = null;
                if (Os.getOperatingSystemType().toString().equals("Linux")) {
                    dir = new File("/home/" + Os.username() + "/Music");
                } else if (Os.getOperatingSystemType().toString().equals("Windows")){
                    dir = new File("C:\\Users\\"+Os.username()+"\\Music");
                }
                else if(Objects.equals(Os.getOperatingSystemType().toString(), "MacOS")) {
                    dir = null;
                } else if(Objects.equals(Os.getOperatingSystemType().toString(), "Other")){
                    dir = null;
                }

                listSongs(dir);

//            }
//        }).start();
    }

    /*
    * List songs is a recursive method to search files
    * having its starting point a specified folder "dir"
    * and puts them in a linked list (could be any) and
    * those files ends with ".mp3", in other words mp3 files
    */
    private static void listSongs(File dir){
    //    ################# Future Implementation, improving and searching all Folders  ################
    //        FilenameFilter filter = new FilenameFilter() {
    //            @Override
    //            public boolean accept(File file, String s) {
    //                return s.endsWith(".mp3");
    //            }
    //        };
    //        pathnames = f.list(filter);
    //


        File[] files = dir.listFiles();

        if (files != null && files.length > 0) {
            for (File file : files) {
                // Check if the file is a directory
                if (file.isDirectory()) {
                    // We will not print the directory name, just use it as a new
                    // starting point to list files from
                    listSongs(new File(file.getAbsolutePath()));
                } else {
                    // We can use .length() to get the file size
                    //System.out.println(file.getName() + " (size in bytes: " + file.length()+")");
                    if (file.toString().endsWith(".mp3")){
                        //allSongs.addEnd(file.getAbsoluteFile());
                        allSongs.addEnd(new Song(file));
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Music{\n" +
                "song=\n" + song +
                ",\n id=" + id +
                '}';
    }
}
