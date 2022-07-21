package com.uce.musicplayer;

import com.uce.musicplayer.music.Song;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SongViewController {
    @FXML
    private Label vAlbum;

    @FXML
    private Label vArtist;

    @FXML
    private Label vStyle;

    @FXML
    private Label vTime;

    @FXML
    private Label vTitle;

    @FXML
    private Label vYear;
    Song song;

    public void setData(Song song){
        this.song = song;
        this.vTitle.setText(song.getTitle());
        this.vArtist.setText(song.getAuthor());
        this.vAlbum.setText(song.getAlbum());
        this.vYear.setText(song.getComments());
        this.vStyle.setText(song.getGenres());
        this.vTime.setText(song.getAuthor());
    }
}
