package com.tonevellah.farfromhome;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import repository.TVRepository;
import service.TVService;

import java.net.URL;
import java.util.ResourceBundle;

public class TVInterface implements Initializable {
    @FXML
    private Button button_logout;
    @FXML
    private Button button_home;
    @FXML
    private ChoiceBox<String> choiceBoxChannel;
    @FXML
    private Button button_power;

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

        button_power.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });
        choiceBoxChannel.getStylesheets().add("/cssStyle/BoxSizeChannel.css");
        choiceBoxChannel.setValue(TVService.Channel());
        choiceBoxChannel.getItems().addAll(TVService.TVChannelPrint());

    }
}
