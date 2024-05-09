package com.github.ManoloCosano72;

import com.github.ManoloCosano72.view.AppController;
import com.github.ManoloCosano72.view.Scenes;
import com.github.ManoloCosano72.view.View;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class App extends Application {

    public static Scene scene;
    public static Stage stage;
    public static AppController currentController;

    //este el es primer método que se ejecuta al abrir la primera ventana
    @Override
    public void start(Stage stage) throws IOException {

    }

    public static void setRoot(String fxml) throws IOException {
        //scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}