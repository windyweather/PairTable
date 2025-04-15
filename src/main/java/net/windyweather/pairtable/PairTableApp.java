package net.windyweather.pairtable;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PairTableApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PairTableApp.class.getResource("pairtable-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 380);
        stage.setTitle("Pair Table Test");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}