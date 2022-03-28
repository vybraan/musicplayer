module com.uce.musicplayer {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires javafx.media;

    opens com.uce.musicplayer to javafx.fxml;
    exports com.uce.musicplayer;
}