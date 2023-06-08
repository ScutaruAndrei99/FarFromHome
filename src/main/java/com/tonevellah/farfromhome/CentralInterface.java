package com.tonevellah.farfromhome;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import service.CentralService;

import java.net.URL;
import java.util.ResourceBundle;

public class CentralInterface implements Initializable {
    @FXML
    private Button button_logout;
    @FXML
    private Button button_home;
    @FXML
    private Button button_upTemperature;
    @FXML
    private Button button_downTemperature;
    @FXML
    public Text text_temperatureSet;
    @FXML
    public Text text_temperature;
    @FXML
    public Text text_humidity;

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
        button_upTemperature.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                CentralService.up();
                text_temperatureSet.setText(CentralService.temperatureSet());
            }
        });
        button_downTemperature.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                CentralService.down();
                text_temperatureSet.setText(CentralService.temperatureSet());
            }
        });
    }
}
