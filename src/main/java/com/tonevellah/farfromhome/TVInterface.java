package com.tonevellah.farfromhome;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import service.TVService;

import java.net.URL;
import java.util.ResourceBundle;

public class TVInterface implements Initializable {
    @FXML
    private Button button_logout;
    @FXML
    private Button button_home;
    @FXML
    private Button button_power;
    @FXML
    private ComboBox<String> comboBoxChannel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        DBUtils db = new DBUtils();
        TVService ts = new TVService();

        button_home.setOnAction(actionEvent -> db.changeScene(actionEvent, "/interfaces/logged-in.fxml", "Logged"));

        button_logout.setOnAction(actionEvent -> db.changeScene(actionEvent, "/interfaces/login.fxml", "Login!"));

        button_power.setOnAction(actionEvent -> {

        });
        comboBoxChannel.getStylesheets().add("/cssStyle/BoxSizeChannel.css");
        comboBoxChannel.getItems().addAll(ts.TVChannelShow());
        comboBoxChannel.setValue(ts.Channel());
        comboBoxChannel.setOnMouseClicked(event -> comboBoxChannel.show());
        comboBoxChannel.setOnAction(actionEvent ->  ts.ChannelSelected(comboBoxChannel.getValue()));


    }
}
