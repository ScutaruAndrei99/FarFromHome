package com.tonevellah.farfromhome;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import service.ElevatorService;

import java.net.URL;
import java.util.ResourceBundle;

public class ElevatorInterface implements Initializable {
    @FXML
    private Button button_logout, button_enter, button_home, button_alarm, button_call;
    @FXML
    private Button button_doorClose, button_doorOpen, button_elevatorStop;
    @FXML
    private Button button_0, button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9;
    @FXML
    private TextField textFieldFloor;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SceneManager db = new SceneManager();
        ElevatorService es = new ElevatorService();

        button_home.setOnAction(actionEvent -> db.changeScene(actionEvent, "/interfaces/logged-in.fxml",
                "Welcome!"));
        button_logout.setOnAction(actionEvent -> db.changeScene(actionEvent, "/interfaces/login.fxml",
                "Login!"));
        button_alarm.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Esti sigur ca vrei sa apesi butonu de urgenta?");
            alert.show();
        });
        button_0.setOnAction(event -> textFieldFloor.setText("0"));
        button_1.setOnAction(event -> textFieldFloor.setText("1"));
        button_2.setOnAction(event -> textFieldFloor.setText("2"));
        button_3.setOnAction(event -> textFieldFloor.setText("3"));
        button_4.setOnAction(event -> textFieldFloor.setText("4"));
        button_5.setOnAction(event -> textFieldFloor.setText("5"));
        button_6.setOnAction(event -> textFieldFloor.setText("6"));
        button_7.setOnAction(event -> textFieldFloor.setText("7"));
        button_8.setOnAction(event -> textFieldFloor.setText("8"));
        button_9.setOnAction(event -> textFieldFloor.setText("9"));
        button_enter.setOnAction(event -> {
            int floor = Integer.parseInt(textFieldFloor.getText());
            es.choiceFloor(floor);
            textFieldFloor.setText("");
        });
        button_doorClose.setOnAction(event -> {


        });
    }
}
