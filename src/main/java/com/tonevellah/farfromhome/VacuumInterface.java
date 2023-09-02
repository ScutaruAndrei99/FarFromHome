package com.tonevellah.farfromhome;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class VacuumInterface implements Initializable {
    @FXML
    private Button button_logout;
    @FXML
    private Button button_home;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        DBUtils db = new DBUtils();

        button_home.setOnAction(actionEvent -> db.changeScene(actionEvent, "/interfaces/logged-in.fxml", "Logged"));

        button_logout.setOnAction(actionEvent -> db.changeScene(actionEvent, "/interfaces/login.fxml", "Login!"));
    }
}
