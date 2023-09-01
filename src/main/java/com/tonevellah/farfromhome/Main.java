package com.tonevellah.farfromhome;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
//        Stage stage =new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/interfaces/login.fxml"));
        primaryStage.setTitle("Login!");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setMaximized(false);
        primaryStage.setResizable(false);
        Image icon = new Image("/images/Icon_FFH.jpg");
        primaryStage.getIcons().add(icon);
        primaryStage.show();
    }
    public static void main(String[] args) {launch(args);}
}
