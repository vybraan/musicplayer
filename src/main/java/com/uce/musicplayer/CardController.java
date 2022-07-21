package com.uce.musicplayer;

import com.uce.musicplayer.music.Song;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CardController {
    @FXML
    private ImageView coverImage;
    @FXML
    private Label songAuthor;
    @FXML
    private Label songTitle;
    public void setData(Song song){
        Image img = song.getCover();
        this.coverImage.setImage(img);
        this.songAuthor.setText(song.getAuthor());
        this.songTitle.setText(song.getTitle());
    }
}
