package com.uce.musicplayer;

import com.uce.musicplayer.music.Music;
import com.uce.musicplayer.music.Song;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.control.skin.ListViewSkin;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private HBox playQueueCard;
    @FXML
    private HBox recentlyPlayedCard;
    @FXML
    private FlowPane newlyAddedCard;
    @FXML
    private AnchorPane newlyAddedPane;
    @FXML
    private VBox hSongView;
//    @FXML
//    private ScrollPane hSongScroll;

    private ArrayList<Music> AllSongs;
    private ArrayList<Song> PlayQueue;
    private ArrayList<Song> Favourites;
    private ArrayList<Song> MostPlayed;
    private ArrayList<Song> NewlyAdded;
    private ArrayList<Song> RecentlyPlayed;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //hSongView.setPrefWidth(hSongScroll.getWidth());


        //Some startup data
        //Music.updateSongs();
        //Music.updateDatabase();
        AllSongs = Music.startupData();
        //Some startup data


        //=================================================================
        //Setting up the playque # Note this here is just a temporary implementation.

        //ListView llll = new ListView();

        PlayQueue = new ArrayList<>(PlayQueue());
        hSongView.fillWidthProperty().set(true);

        int i = 0;
        try {
            for (Song v: PlayQueue) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("views/SongView.fxml"));
                HBox songview = fxmlLoader.load();
                //songview.width//.set(true);

                SongViewController songViewController = fxmlLoader.getController();
                songViewController.setData(v);

                if (i % 2==0){
                    songview.getStyleClass().add("viewLight");
                }else {
                    songview.getStyleClass().add("viewDark");

                }

                hSongView.getChildren().add(songview);

                i++;
                //playQueueCard.getChildren().add(queueBox);
            }
         } catch (IOException e) {
            e.printStackTrace();
        }

        //=================================================================
        //Setting up the Recently Played # Note this here is just a temporary implementation.



//        RecentlyPlayed = new ArrayList<>(RecentlyPlayed());
//        try {
//            for (Song v: RecentlyPlayed) {
//
//                FXMLLoader fxmlLoader = new FXMLLoader();
//                fxmlLoader.setLocation(getClass().getResource("views/card.fxml"));
//                VBox queueBox = fxmlLoader.load();
//
//                CardController cardController = fxmlLoader.getController();
//                cardController.setData(v);
//                recentlyPlayedCard.getChildren().add(queueBox);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //=================================================================
        //Setting up the Newly Added # Note this here is just a temporary implementation.



//        NewlyAdded = new ArrayList<>(NewlyAdded());
//        try {
//            for (Song v: NewlyAdded) {
//
//                FXMLLoader fxmlLoader = new FXMLLoader();
//                fxmlLoader.setLocation(getClass().getResource("views/card.fxml"));
//                VBox queueBox = fxmlLoader.load();
//
//                CardController cardController = fxmlLoader.getController();
//                cardController.setData(v);
//                recentlyPlayedCard.getChildren().add(queueBox);
//
//                newlyAddedCard.getChildren().add(queueBox); //testing
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    //Method to get the Play Queue songs.
    private ArrayList<Song> PlayQueue(){
        ArrayList<Song> ls  = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            ls.add(AllSongs.get(i).getSong());
        }

//
//        //temp to remove this bellow
//        File file = new File(getClass().getResourceAsStream("cover.jpg").toString());
//        Song song = new Song(file);
//
//
//        song.setCover(new Image(getClass().getResourceAsStream("cover.jpg")));
//        song.setAlbum("Album");
//        song.setAuthor("Ailton Bauque");
//        song.setGenres("Pop");
//        song.setTitle("I'm the one");
//        ls.add(song);
//
//        song.setCover(new Image(getClass().getResourceAsStream("cover.jpg")));
//        song.setAlbum("Album");
//        song.setAuthor("Ailton Bauque");
//        song.setGenres("Pop");
//        song.setTitle("I'm the one");
//        ls.add(song);
//
//        song.setCover(new Image(getClass().getResourceAsStream("cover.jpg")));
//        song.setAlbum("Album");
//        song.setAuthor("Ailton Bauque");
//        song.setGenres("Pop");
//        song.setTitle("I'm the one");
//        ls.add(song);
//
//        song.setCover(new Image(getClass().getResourceAsStream("cover.jpg")));
//        song.setAlbum("Album");
//        song.setAuthor("Ailton Bauque");
//        song.setGenres("Pop");
//        song.setTitle("I'm the one");
//        ls.add(song);
//
//        song.setCover(new Image(getClass().getResourceAsStream("cover.jpg")));
//        song.setAlbum("Album");
//        song.setAuthor("Ailton Bauque");
//        song.setGenres("Pop");
//        song.setTitle("I'm the one");
//        ls.add(song);
//
//        song.setCover(new Image(getClass().getResourceAsStream("cover.jpg")));
//        song.setAlbum("Album");
//        song.setAuthor("Ailton Bauque");
//        song.setGenres("Pop");
//        song.setTitle("I'm the one");
//        ls.add(song);
//
//        song.setCover(new Image(getClass().getResourceAsStream("cover.jpg")));
//        song.setAlbum("Album");
//        song.setAuthor("Ailton Bauque");
//        song.setGenres("Pop");
//        song.setTitle("I'm the one");
//        ls.add(song);
//
//        song.setCover(new Image(getClass().getResourceAsStream("cover.jpg")));
//        song.setAlbum("Album");
//        song.setAuthor("Ailton Bauque");
//        song.setGenres("Pop");
//        song.setTitle("I'm the one");
//        ls.add(song);
//
//        song.setCover(new Image(getClass().getResourceAsStream("cover.jpg")));
//        song.setAlbum("Album");
//        song.setAuthor("Ailton Bauque");
//        song.setGenres("Pop");
//        song.setTitle("I'm the one");
//        ls.add(song);
        return ls;
    }

    //Method to get the recently played songs.
    private ArrayList<Song> RecentlyPlayed(){
        ArrayList<Song> ls  = new ArrayList<>();

        //temp to remove this bellow
        File file = new File(getClass().getResourceAsStream("cover.jpg").toString());
        Song song = new Song(file);


        song.setCover(new Image(getClass().getResourceAsStream("cover.jpg")));
        song.setAlbum("Album");
        song.setAuthor("Ailton Bauque");
        song.setGenres("Pop");
        song.setTitle("I'm the one");
        ls.add(song);

        song.setCover(new Image(getClass().getResourceAsStream("cover.jpg")));
        song.setAlbum("Album");
        song.setAuthor("Ailton Bauque");
        song.setGenres("Pop");
        song.setTitle("I'm the one");
        ls.add(song);

        song.setCover(new Image(getClass().getResourceAsStream("cover.jpg")));
        song.setAlbum("Album");
        song.setAuthor("Ailton Bauque");
        song.setGenres("Pop");
        song.setTitle("I'm the one");
        ls.add(song);

        song.setCover(new Image(getClass().getResourceAsStream("cover.jpg")));
        song.setAlbum("Album");
        song.setAuthor("Ailton Bauque");
        song.setGenres("Pop");
        song.setTitle("I'm the one");
        ls.add(song);

        song.setCover(new Image(getClass().getResourceAsStream("cover.jpg")));
        song.setAlbum("Album");
        song.setAuthor("Ailton Bauque");
        song.setGenres("Pop");
        song.setTitle("I'm the one");
        ls.add(song);

        song.setCover(new Image(getClass().getResourceAsStream("cover.jpg")));
        song.setAlbum("Album");
        song.setAuthor("Ailton Bauque");
        song.setGenres("Pop");
        song.setTitle("I'm the one");
        ls.add(song);

        song.setCover(new Image(getClass().getResourceAsStream("cover.jpg")));
        song.setAlbum("Album");
        song.setAuthor("Ailton Bauque");
        song.setGenres("Pop");
        song.setTitle("I'm the one");
        ls.add(song);

        song.setCover(new Image(getClass().getResourceAsStream("cover.jpg")));
        song.setAlbum("Album");
        song.setAuthor("Ailton Bauque");
        song.setGenres("Pop");
        song.setTitle("I'm the one");
        ls.add(song);

        song.setCover(new Image(getClass().getResourceAsStream("cover.jpg")));
        song.setAlbum("Album");
        song.setAuthor("Ailton Bauque");
        song.setGenres("Pop");
        song.setTitle("I'm the one");
        ls.add(song);
        return ls;
    }

    //Method to get the newly Added Songs.
    private ArrayList<Song> NewlyAdded(){
        ArrayList<Song> ls  = new ArrayList<>();

        //temp to remove this bellow
        File file = new File(getClass().getResourceAsStream("cover.jpg").toString());
        Song song = new Song(file);


        song.setCover(new Image(getClass().getResourceAsStream("cover.jpg")));
        song.setAlbum("Album");
        song.setAuthor("Ailton Bauque");
        song.setGenres("Pop");
        song.setTitle("I'm the one");
        ls.add(song);

        song.setCover(new Image(getClass().getResourceAsStream("cover.jpg")));
        song.setAlbum("Album");
        song.setAuthor("Ailton Bauque");
        song.setGenres("Pop");
        song.setTitle("I'm the one");
        ls.add(song);

        song.setCover(new Image(getClass().getResourceAsStream("cover.jpg")));
        song.setAlbum("Album");
        song.setAuthor("Ailton Bauque");
        song.setGenres("Pop");
        song.setTitle("I'm the one");
        ls.add(song);

        song.setCover(new Image(getClass().getResourceAsStream("cover.jpg")));
        song.setAlbum("Album");
        song.setAuthor("Ailton Bauque");
        song.setGenres("Pop");
        song.setTitle("I'm the one");
        ls.add(song);

        song.setCover(new Image(getClass().getResourceAsStream("cover.jpg")));
        song.setAlbum("Album");
        song.setAuthor("Ailton Bauque");
        song.setGenres("Pop");
        song.setTitle("I'm the one");
        ls.add(song);

        song.setCover(new Image(getClass().getResourceAsStream("cover.jpg")));
        song.setAlbum("Album");
        song.setAuthor("Ailton Bauque");
        song.setGenres("Pop");
        song.setTitle("I'm the one");
        ls.add(song);

        song.setCover(new Image(getClass().getResourceAsStream("cover.jpg")));
        song.setAlbum("Album");
        song.setAuthor("Ailton Bauque");
        song.setGenres("Pop");
        song.setTitle("I'm the one");
        ls.add(song);

        song.setCover(new Image(getClass().getResourceAsStream("cover.jpg")));
        song.setAlbum("Album");
        song.setAuthor("Ailton Bauque");
        song.setGenres("Pop");
        song.setTitle("I'm the one");
        ls.add(song);

        song.setCover(new Image(getClass().getResourceAsStream("cover.jpg")));
        song.setAlbum("Album");
        song.setAuthor("Ailton Bauque");
        song.setGenres("Pop");
        song.setTitle("I'm the one");
        ls.add(song);

        song.setCover(new Image(getClass().getResourceAsStream("cover.jpg")));
        song.setAlbum("Album");
        song.setAuthor("Ailton Bauque");
        song.setGenres("Pop");
        song.setTitle("I'm the one");
        ls.add(song);

        song.setCover(new Image(getClass().getResourceAsStream("cover.jpg")));
        song.setAlbum("Album");
        song.setAuthor("Ailton Bauque");
        song.setGenres("Pop");
        song.setTitle("I'm the one");
        ls.add(song);

        song.setCover(new Image(getClass().getResourceAsStream("cover.jpg")));
        song.setAlbum("Album");
        song.setAuthor("Ailton Bauque");
        song.setGenres("Pop");
        song.setTitle("I'm the one");
        ls.add(song);

        song.setCover(new Image(getClass().getResourceAsStream("cover.jpg")));
        song.setAlbum("Album");
        song.setAuthor("Ailton Bauque");
        song.setGenres("Pop");
        song.setTitle("I'm the one");
        ls.add(song);

        song.setCover(new Image(getClass().getResourceAsStream("cover.jpg")));
        song.setAlbum("Album");
        song.setAuthor("Ailton Bauque");
        song.setGenres("Pop");
        song.setTitle("I'm the one");
        ls.add(song);

        song.setCover(new Image(getClass().getResourceAsStream("cover.jpg")));
        song.setAlbum("Album");
        song.setAuthor("Ailton Bauque");
        song.setGenres("Pop");
        song.setTitle("I'm the one");
        ls.add(song);

        song.setCover(new Image(getClass().getResourceAsStream("cover.jpg")));
        song.setAlbum("Album");
        song.setAuthor("Ailton Bauque");
        song.setGenres("Pop");
        song.setTitle("I'm the one");
        ls.add(song);

        song.setCover(new Image(getClass().getResourceAsStream("cover.jpg")));
        song.setAlbum("Album");
        song.setAuthor("Ailton Bauque");
        song.setGenres("Pop");
        song.setTitle("I'm the one");
        ls.add(song);

        song.setCover(new Image(getClass().getResourceAsStream("cover.jpg")));
        song.setAlbum("Album");
        song.setAuthor("Ailton Bauque");
        song.setGenres("Pop");
        song.setTitle("I'm the one");
        ls.add(song);
        return ls;
    }

    //Method to get the Favourites Songs.
    private ArrayList<Song> Favourites(){
        ArrayList<Song> ls  = new ArrayList<>();

        return ls;
    }

    //Method to get the Mostly Played Songs.
    private ArrayList<Song> MostPlayed(){
        ArrayList<Song> ls  = new ArrayList<>();

        return ls;
    }


}
