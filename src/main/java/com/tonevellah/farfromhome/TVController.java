package com.tonevellah.farfromhome;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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
    private Circle circle_status;
    @FXML
    private ComboBox<String> comboBoxChannel;
    @FXML
    private MediaView mediaView_channel;
    private Media media_channel;
    private MediaPlayer mediaPlayer_channel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SceneManager db = new SceneManager();
        TVService ts = new TVService();

        button_home.setOnAction(actionEvent -> db.changeScene(actionEvent, "/interfaces/logged-in.fxml",
                "Welcome!"));

        button_logout.setOnAction(actionEvent -> db.changeScene(actionEvent, "/interfaces/login.fxml",
                "Login!"));

        button_power.setOnAction(actionEvent -> {
            ts.PressButtonPower();
            if (circle_status.getFill().toString().equals("0xff0000ff")){
                circle_status.setFill(Color.GREEN);
//                ts.ChangeChannel();
            } else {
                circle_status.setFill(Color.RED);

            }
        });
        comboBoxChannel.getStylesheets().add("/cssStyle/BoxSizeChannel.css");
        comboBoxChannel.getItems().addAll(ts.TVChannelShow());
        comboBoxChannel.setValue(ts.Channel());
        comboBoxChannel.setOnMouseClicked(event -> comboBoxChannel.show());
        comboBoxChannel.setOnAction(actionEvent ->  ts.SelectedChannel(comboBoxChannel.getValue()));

    }
    public void powerPrepare(boolean value) {
        if (value==true) {
            circle_status.setFill(Color.GREEN);
        } else {
            circle_status.setFill(Color.RED);
        }
    }

}
