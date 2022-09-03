//package com.uce.musicplayer;
//
//import javafx.application.Application;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.ScrollPane;
//import javafx.scene.image.Image;
//import javafx.stage.Stage;
//import javafx.stage.StageStyle;
//
//import java.io.IOException;
//
//public class Home extends Application {
//    @FXML
//    private ScrollPane home_scroll;
//
//    @Override
//    public void start(Stage stage) throws Exception {
//        FXMLLoader fxmlLoader = new FXMLLoader(Home.class.getResource("home.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        stage.setTitle("Music Player");
//        stage.setScene(scene);
//        stage.setResizable(false);
//        stage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
