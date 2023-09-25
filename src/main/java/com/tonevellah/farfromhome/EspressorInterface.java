package com.tonevellah.farfromhome;

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

        DBUtils db = new DBUtils();
        EspressorService es = new EspressorService();

        button_home.setOnAction(actionEvent -> db.changeScene(actionEvent, "/interfaces/logged-in.fxml",
                "Welcome!"));

        button_logout.setOnAction(actionEvent -> db.changeScene(actionEvent, "/interfaces/login.fxml",
                "Login!"));

        button_espressor.setOnAction(event -> {
            db.expressorPrepareCoffee(event,"/interfaces/prepareCoffee.fxml");
            es.typeCoffeeSelect("espresso");
        });

        button_cappuccino.setOnAction(event -> {
            db.expressorPrepareCoffee(event,"/interfaces/prepareCoffee.fxml");
            es.typeCoffeeSelect("cappuccino");
        });

        button_latte.setOnAction(event -> {
            db.expressorPrepareCoffee(event,"/interfaces/prepareCoffee.fxml");
            es.typeCoffeeSelect("latte");
        });

    }
}
