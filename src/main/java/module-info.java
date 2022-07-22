module com.uce.musicplayer {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires javafx.media;
    requires json.simple;
    requires com.google.gson;

    opens com.uce.musicplayer to javafx.fxml;
    exports com.uce.musicplayer;
//    exports com.uce.musicplayer.main;
//    exports com.uce.musicplayer.controller;
    exports com.uce.musicplayer.music;
    exports com.uce.musicplayer.rstructure;
    exports com.uce.musicplayer.syspropriety;
    exports com.uce.musicplayer.model;

}