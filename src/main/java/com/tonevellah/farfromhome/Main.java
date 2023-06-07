package com.tonevellah.farfromhome;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfaces/login.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Login!");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setMaximized(false);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static void main(String[] args) {launch(args);}
}
