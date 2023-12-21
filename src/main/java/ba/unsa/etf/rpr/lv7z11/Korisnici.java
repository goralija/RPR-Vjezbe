package ba.unsa.etf.rpr.lv7z11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Korisnici extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Korisnici.class.getResource("korisnici.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 620, 380);
        stage.setTitle("Korisnici");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}