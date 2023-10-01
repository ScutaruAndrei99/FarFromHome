package com.tonevellah.farfromhome;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class LoggedInController implements Initializable {

    @FXML
    private Button button_logout;
    @FXML
    private Button button_home;
    @FXML
    private Button button_light;
    @FXML
    private Button button_gate;
    @FXML
    private Button button_TV;
    @FXML
    private Button button_coffee;
    @FXML
    private Button button_central;
    @FXML
    private Button button_elevator;
    @FXML
    private Button button_curtain;
    @FXML
    private Button button_vacuum;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SceneManager db = new SceneManager();

        button_home.setOnAction(actionEvent -> db.changeScene(actionEvent,"/interfaces/logged-in.fxml",
                "Welcome!"));

        button_logout.setOnAction(event -> db.changeScene(event, "/interfaces/login.fxml","Login!"));

        button_light.setOnAction(actionEvent -> db.lightScene(actionEvent,"/interfaces/lightRoom.fxml"));

        button_gate.setOnAction(actionEvent -> db.gateScene(actionEvent,"/interfaces/gate.fxml"));

        button_TV.setOnAction(event -> db.tvScene(event,"/interfaces/tv.fxml"));

        button_coffee.setOnAction(event -> db.espressorScene(event,"/interfaces/espressor.fxml"));

        button_central.setOnAction(event -> db.centralScene(event,"/interfaces/central.fxml"));

        button_elevator.setOnAction(event -> db.elevatorScene(event,"/interfaces/elevator.fxml"));

        button_curtain.setOnAction(event -> db.curtainsScene(event,"/interfaces/curtains.fxml"));

        button_vacuum.setOnAction(event -> db.vacuumScene(event,"/interfaces/vacuum.fxml"));

    }

}