//package com.uce.musicplayer;
//
//import javafx.animation.TranslateTransition;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Parent;
//import javafx.scene.control.Button;
//import javafx.scene.control.ListView;
//import javafx.scene.control.ScrollPane;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.Pane;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
//import javafx.util.Duration;
//import org.kordamp.ikonli.javafx.FontIcon;
//
//import java.io.File;
//import java.io.FilenameFilter;
//import java.io.IOException;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.ResourceBundle;
//import java.util.Timer;
//import java.util.TimerTask;
//
//public class HomeController implements Initializable {
//
//    @FXML
//    private AnchorPane sidebar, home_anchor, play_queue_anchor, music_info_anchor, folders_anchor, settings_anchor;
//
//    @FXML
//    private ImageView Menu, Menu_play_queue, Menu_music_info, Menu_folders, Menu_settings;
//
//    @FXML
//    private Button btn_home, btn_queue, btn_playlist, btn_artists, btn_songs, btn_genres, btn_folders, btn_settings,
//            btn_albums, btn_music_playlist, btn_music_artists, btn_music_albums, btn_music_songs, btn_music_genres;
//
//    @FXML
//    private Pane music_playlist_pane, music_artists_pane, music_albums_pane, music_songs_pane, music_genres_pane;
//
//    @FXML
//    private ListView <String>song_view;
//
//    @FXML
//    private BorderPane bottom_player;
//    @FXML
//    private FontIcon btn_play ,btn_nextn, btn_previous;
//
//    @FXML ScrollPane home_scroll;
//
//
//    private File[] songs;
//    private int songNumber;
//    private Timer timer;
//    private TimerTask task;
//    private boolean running = false;
//    Media media;
//    MediaPlayer mediaPlayer;
//    String current;
//
//
//
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        sidebar.setTranslateX(-200);
//        setUpSongs();
//        showBottomPlayer();
//
//
////        Parent ccc = null;
////        try {
////            ccc = new FXMLLoader(Home.class.getResource("play_queue_box.fxml")).load();
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////        home_scroll.getContent();
//
//        song_view.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
//                current = song_view.getSelectionModel().getSelectedItem();
//                play(current);
//
////                songNumber = songs.indexOf(current);
//            }
//        });
//
//        btn_play.setOnMouseClicked( mouseEvent -> {
//
//            if (running == true){
//                if(btn_play.getIconLiteral() == "fa-pauses"){
//                    mediaPlayer.pause();
//                    btn_play.setIconLiteral("fa-play");
//                }else {
//                    mediaPlayer.play();
//                    btn_play.setIconLiteral("fa-pause");
//                }
//            }
//            System.out.println(btn_play.getIconLiteral());
//        });
//        btn_previous.setOnMouseClicked(mouseEvent -> {
//            try {
//                System.out.println(songs[songNumber]);
//                current = songs[songNumber -1].toString();
//                System.out.println(current);
//                play(current);
//                songNumber--;
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//
//        });
//        btn_nextn.setOnMouseClicked(mouseEvent -> {
//            try {
//                System.out.println(songs[songNumber]);
//                current = songs[songNumber +1].toString();
//                System.out.println(current);
//                play(current);
//                songNumber++;
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        });
//
//
//
//        //Start expading the menu bar
//        //= //= === === //= //= === === //= //= === ===
//        //= //= === === //= //= === === //= //= === ===
//        //= //= === === //= //= === === //= //= === ===
//        Menu.setOnMouseClicked(mouseEvent -> showSidebar());
//        Menu_play_queue.setOnMouseClicked(mouseEvent -> showSidebar());
//        Menu_music_info.setOnMouseClicked(mouseEvent -> showSidebar());
//        Menu_folders.setOnMouseClicked(mouseEvent -> showSidebar());
//        Menu_settings.setOnMouseClicked(mouseEvent -> showSidebar());
//
//        //End Of Menus and start of buttons
//        //= //= === === //= //= === === //= //= === ===
//        //= //= === === //= //= === === //= //= === ===
//        //= //= === === //= //= === === //= //= === ===
//
//
//        btn_home.setOnMouseClicked(mouseEvent -> {
//            collapseSidbar("home_anchor");
//        });
//
//        btn_queue.setOnMouseClicked(mouseEvent -> {
//            collapseSidbar("play_queue_anchor");
//        });
//
//        btn_playlist.setOnMouseClicked(mouseEvent -> {
//            collapseSidbar("music_info_anchor");
//            music_playlist_pane.toFront();
//        });
//
//        btn_artists.setOnMouseClicked(mouseEvent -> {
//            collapseSidbar("music_info_anchor");
//            music_artists_pane.toFront();
//        });
//
//        btn_albums.setOnMouseClicked(mouseEvent -> {
//            collapseSidbar("music_info_anchor");
//            music_albums_pane.toFront();
//        });
//
//        btn_songs.setOnMouseClicked(mouseEvent -> {
//            collapseSidbar("music_info_anchor");
//            music_songs_pane.toFront();
//        });
//
//        btn_genres.setOnMouseClicked(mouseEvent -> {
//            collapseSidbar("music_info_anchor");
//            music_genres_pane.toFront();
//        });
//
//        btn_folders.setOnMouseClicked(mouseEvent -> {
//            collapseSidbar("folders_anchor");
//        });
//
//        btn_settings.setOnMouseClicked(mouseEvent -> {
//            collapseSidbar("settings_anchor");
//        });
//
//        //End Of Menu Buttons and start of Lybrary buttons
//        //= //= === === //= //= === === //= //= === ===
//        //= //= === === //= //= === === //= //= === ===
//        //= //= === === //= //= === === //= //= === ===
//
//        btn_music_playlist.setOnMouseClicked(mouseEvent -> {
//            music_playlist_pane.toFront();
//        });
//
//        btn_music_artists.setOnMouseClicked(mouseEvent -> {
//            music_artists_pane.toFront();
//        });
//
//        btn_music_albums.setOnMouseClicked(mouseEvent -> {
//            music_albums_pane.toFront();
//        });
//
//        btn_music_songs.setOnMouseClicked(mouseEvent -> {
//            music_songs_pane.toFront();
//        });
//
//        btn_music_genres.setOnMouseClicked(mouseEvent -> {
//            music_genres_pane.toFront();
//        });
//
//
//
//
//    }
//
////============================================   My custom methods   ===================================================
//    public void showBottomPlayer(){
//        bottom_player.toFront();
//    }
//    public void showSidebar(){
//        TranslateTransition slide = new TranslateTransition(Duration.seconds(0.4));
//        slide.setNode(sidebar);
//        slide.setToX(0);
//        slide.play();
//
//        sidebar.setTranslateX(-200);
//        sidebar.toFront();
//    }
//    public void collapseSidbar(String string){
//
//        TranslateTransition slide = new TranslateTransition(Duration.seconds(0.4));
//        slide.setNode(sidebar);
//        slide.setToX(-200);
//        slide.play();
//
//        sidebar.setTranslateX(0);
//        sidebar.toBack();
//
//        switch (string){
//            case "home_anchor":
//                play_queue_anchor.toBack();
//                music_info_anchor.toBack();
//                folders_anchor.toBack();
//                settings_anchor.toBack();
//                home_anchor.toFront();
//                showBottomPlayer();
//                break;
//            case "play_queue_anchor":
//                play_queue_anchor.toFront();
//                music_info_anchor.toBack();
//                folders_anchor.toBack();
//                settings_anchor.toBack();
//                home_anchor.toBack();
//                showBottomPlayer();
//                break;
//            case "music_info_anchor":
//                play_queue_anchor.toBack();
//                music_info_anchor.toFront();
//                folders_anchor.toBack();
//                settings_anchor.toBack();
//                home_anchor.toBack();
//                showBottomPlayer();
//                break;
//            case "folders_anchor":
//                play_queue_anchor.toBack();
//                music_info_anchor.toBack();
//                folders_anchor.toFront();
//                settings_anchor.toBack();
//                home_anchor.toBack();
//                showBottomPlayer();
//                break;
//            case "settings_anchor":
//                play_queue_anchor.toBack();
//                music_info_anchor.toBack();
//                folders_anchor.toBack();
//                settings_anchor.toFront();
//                home_anchor.toBack();
//                showBottomPlayer();
//                break;
//        }
//    }
//    public void setUpSongs(){
//        String pathnames[];
//        File f = new File("/home/vybraan/Music");
//
//        FilenameFilter filter = new FilenameFilter() {
//        @Override
//        public boolean accept(File file, String s) {
//            return s.endsWith(".mp3");
//        }
//    };
//        pathnames = f.list(filter);
//        song_view.getItems().addAll(pathnames);
//        songs = new File[pathnames.length];
//
//        for (int i = 0; i < pathnames.length; i++) {
//            if (pathnames[i] != null) {
//                songs[i] = new File(pathnames[i]);
//            }
//        }
//    }
//
//    public void play(String file){
//        if (running == false){
//            File f = new File("/home/vybraan/Music/"+file);
//            System.out.print(f.getAbsoluteFile());
//            media = new Media(f.toURI().toString());
//            mediaPlayer = new MediaPlayer(media);
//            mediaPlayer.setAutoPlay(true);
//            running = true;
//        }else{
//            mediaPlayer.stop();
//            mediaPlayer.dispose();
//            File f = new File("/home/vybraan/Music/"+file);
//            media = new Media(f.toURI().toString());
//            mediaPlayer = new MediaPlayer(media);
//            mediaPlayer.setAutoPlay(true);
//        }
//        mediaPlayer.setOnEndOfMedia(new Runnable() {
//            @Override
//            public void run() {
//                play(current);
//            }
//        });
//        System.out.println(media.getMetadata());
//    }
//    public void pause(){
//
//    }
//    public void next(){
//
//    }
//    public void previous(){
//
//    }
//}
