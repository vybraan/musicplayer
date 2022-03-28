package com.uce.musicplayer.music;

import com.uce.musicplayer.rstructure.List;
import com.uce.musicplayer.rstructure.Node;
import com.uce.musicplayer.syspropriety.Os;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Timer;
import java.util.TimerTask;

public class Music {
    private File[] favourites;
    private File[] mostPlayed;
    private File[] newlyAdded;
    private File[] recentlyPlayed;
    private File[] playQueue;
    private int songNumber;
    private Timer timer;
    private TimerTask task;
    private boolean running;
    private String currentPlayingSong;
    public static List allSongs = new List();


    public static void updateSongs()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {

                File dir = null;
                if (Os.getOperatingSystemType().toString() =="Linux"){
                    dir = new File("/home/"+Os.username()+"/Music");
                }
                else if (Os.getOperatingSystemType().toString() =="Windows"){
                    dir = new File("C:\\Users\\"+Os.username()+"\\Music");
                }
                else if(Os.getOperatingSystemType().toString() =="MacOS"){
                    dir = null;
                }
                else if(Os.getOperatingSystemType().toString() =="Other"){
                    dir = null;
                }

                listSongs(dir);

            }
        }).start();
    }

    private static void listSongs(File dir){
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
                        allSongs.addEnd(file.getAbsoluteFile());
                    }
                }
            }
        }
    }

}
