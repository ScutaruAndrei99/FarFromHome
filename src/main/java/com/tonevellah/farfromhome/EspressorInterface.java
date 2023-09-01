package com.tonevellah.farfromhome;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import service.EspressorService;

import java.net.URL;
import java.util.ResourceBundle;

public class EspressorInterface implements Initializable {
    @FXML
    private Button button_logout;
    @FXML
    private Button button_home;
    @FXML
    private Button button_espressor;
    @FXML
    private Button button_cappuccino;
    @FXML
    private Button button_latte;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        button_home.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeScene(actionEvent, "/interfaces/logged-in.fxml", "Logged");
            }
        });
        button_logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeScene(actionEvent, "/interfaces/login.fxml", "Login!");
            }
        });
        button_espressor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.ExpressorPrepareCoffee(event,"/interfaces/prepareCoffee.fxml");
                EspressorService.typeCoffeeChosen("espresso");
            }
        });
        button_cappuccino.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.ExpressorPrepareCoffee(event,"/interfaces/prepareCoffee.fxml");
                EspressorService.typeCoffeeChosen("cappuccino");
            }
        });
        button_latte.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.ExpressorPrepareCoffee(event,"/interfaces/prepareCoffee.fxml");
                EspressorService.typeCoffeeChosen("latte");
            }
        });
    }
}
