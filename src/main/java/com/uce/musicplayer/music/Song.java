package com.uce.musicplayer.music;

import javafx.beans.Observable;
import javafx.collections.ObservableMap;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Song {
    private String title;
    private String author;
    private String album;
    private String genres;
    private String publisher;
    private String copyRight;
    private String encodedBy;
    private String comments;
    private String lyrics;

    private String path;
    private Image cover;

    public Song(File file){
        this.path = file.getAbsolutePath();
    }

    public Song(String title, String author, String album, String genres, String publisher, String copyRight, String encodedBy, String comments, String lyrics, String path) {
        this.title = title;
        this.author = author;
        this.album = album;
        this.genres = genres;
        this.publisher = publisher;
        this.copyRight = copyRight;
        this.encodedBy = encodedBy;
        this.comments = comments;
        this.lyrics = lyrics;
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCopyRight() {
        return copyRight;
    }

    public void setCopyRight(String copyRight) {
        this.copyRight = copyRight;
    }

    public String getEncodedBy() {
        return encodedBy;
    }

    public void setEncodedBy(String encodedBy) {
        this.encodedBy = encodedBy;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public Image getCover() {
        return cover;
    }

    public void setCover(Image cover) {
        this.cover = cover;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "==================Song======================\n{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", album='" + album + '\'' +
                ", genres='" + genres + '\'' +
                ", publisher='" + publisher + '\'' +
                ", copyRight='" + copyRight + '\'' +
                ", encodedBy='" + encodedBy + '\'' +
                ", comments='" + comments + '\'' +
                ", lyrics='" + lyrics + '\'' +
                ", path='" + path + '\'' +
                ", cover=" + cover +
                '}'+"\n==================Song======================";
    }
}
