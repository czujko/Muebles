package com.ndynmate.muebles;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mueble-vista.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/icono/icono.png")));
        stage.setTitle("Muebles v.1");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        HibernateUtil.inicia();
        launch();
    }
}