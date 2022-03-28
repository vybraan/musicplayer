package com.uce.musicplayer.music;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Song {
    private String author;
    private String title;
    private String album;
    private String genres;
    private MediaPlayer mediaPlayer;


    public Song(String author, String title, String album,String genres, Media media){
        this.author = author;
        this.title = title;
        this.album = album;
        this.genres = genres;
        mediaPlayer = new MediaPlayer(media);
    }
    public Song(Media media){
        mediaPlayer = new MediaPlayer(media);
    }
    public void play(){
        mediaPlayer.dispose();
        mediaPlayer.play();
    }
    public void pause(){
        mediaPlayer.pause();
    }
    public void reset(){
        mediaPlayer.stop();
        mediaPlayer.play();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }
}
