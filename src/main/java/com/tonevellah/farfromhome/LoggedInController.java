package com.tonevellah.farfromhome;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

        button_home.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeScene(actionEvent,"/interfaces/logged-in.fxml","Logged");
            }
        });
        button_logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "/interfaces/login.fxml","Login!");
            }
        });
        button_light.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.lightScene(actionEvent,"/interfaces/lightRoom.fxml");
            }
        });
        button_gate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.gateScene(actionEvent,"/interfaces/gate.fxml");
            }
        });
        button_TV.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.TVScene(event,"/interfaces/tv.fxml");
            }
        });
        button_coffee.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.EspressorScene(event,"/interfaces/espressor.fxml");
            }
        });
        button_central.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.CentralScene(event,"/interfaces/central.fxml");
            }
        });
        button_elevator.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.ElevatorScene(event,"/interfaces/elevator.fxml");
            }
        });
        button_curtain.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.CurtainsScene(event,"/interfaces/curtains.fxml");
            }
        });
        button_vacuum.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.VacuumScene(event,"/interfaces/vacuum.fxml");
            }
        });
    }

}