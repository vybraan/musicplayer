package com.uce.musicplayer.model;


import com.google.gson.JsonElement;
import com.uce.musicplayer.music.Music;
import com.uce.musicplayer.music.Song;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class Data {
    ArrayList<Music> musics = new ArrayList<>();

    public Data(ArrayList<Music> musics){
        this.musics = musics;
    }

    public void updateDatabase(){
        //Create music list
        JSONArray musicList = new JSONArray();

        for (Music music: musics) {
            JSONObject musicObject = new JSONObject();
            musicObject.put("music", parseSongDetails(music));
            musicList.add(musicObject);
        }

        //Write JSON file
        try (FileWriter file = new FileWriter("dstore/media.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(musicList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private static JSONObject parseSongDetails(Music music){
        JSONObject songDetails = new JSONObject();
        songDetails.put("title", music.getSong().getTitle());
        songDetails.put("author", music.getSong().getAuthor());
        songDetails.put("album", music.getSong().getAlbum());
        songDetails.put("genre", music.getSong().getGenres());
        songDetails.put("publisher", music.getSong().getPublisher());
        songDetails.put("copyRight", music.getSong().getCopyRight());
        songDetails.put("encoder", music.getSong().getEncodedBy());
        songDetails.put("comments", music.getSong().getComments());
        songDetails.put("lyrics", music.getSong().getLyrics());
        songDetails.put("path", music.getSong().getPath());

        return songDetails;
    }

    public ArrayList<Music> startUpData(){
        ArrayList<Music> musics = new ArrayList<>();

        //Json Parser to reade the file
        JSONParser jsonParser = new JSONParser();

        try (FileReader fileReader = new FileReader("dstore/media.json")){
            //Read Json file
            Object obj = jsonParser.parse(fileReader);

            JSONArray musicList =(JSONArray) obj;
            //System.out.println(musicList);
            try {
                musicList.forEach(emp -> musics.add(readMusics((JSONObject) emp )));
            } catch (NullPointerException e) {
                Music.updateSongs();
                Music.updateDatabase();
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


        return musics;
    }

    private Music readMusics(JSONObject msc){
        JSONObject song = (JSONObject) msc.get("music");


        String title = (String) song.get("title");
        String author = (String) song.get("author");
        String album = (String) song.get("album");
        String genre = (String) song.get("genre");
        String publisher = (String) song.get("publisher");
        String copyRight = (String) song.get("copyRight");
        String encoder = (String) song.get("encoder");
        String comments = (String) song.get("comments");
        String lyrics = (String) song.get("lyrics");
        String path = (String) song.get("path");


        return  new Music(new Song( title, author, album, genre, publisher, copyRight, encoder, comments, lyrics, path));
    }
}
