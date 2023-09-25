package com.tonevellah.farfromhome;

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

        DBUtils db = new DBUtils();
        CentralService cs = new CentralService();

        button_home.setOnAction(actionEvent -> db.changeScene(actionEvent, "/interfaces/logged-in.fxml",
                "Welcome!"));

        button_logout.setOnAction(actionEvent -> db.changeScene(actionEvent, "/interfaces/login.fxml",
                "Login!"));

        button_upTemperature.setOnAction(event -> {
            cs.upTemperature();
            text_temperatureSet.setText(cs.readTemperature());
        });

        button_downTemperature.setOnAction(event -> {
            cs.downTemperature();
            text_temperatureSet.setText(cs.readTemperature());
        });
    }
}
