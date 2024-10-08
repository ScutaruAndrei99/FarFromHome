package com.tonevellah.farfromhome;

import model.Gate;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import repository.GateRepository;
import service.GateService;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class GateInterface implements Initializable {

    GateRepository gr=new GateRepository();
    GateService gs=new GateService();
    Gate gate=gr.findByID();
    @FXML
    private Button button_logout;
    @FXML
    private Button button_home;
    @FXML
    private Button button_switch;
    @FXML
    public ImageView img_switch;
    @FXML
    public ImageView img_liveCamera;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SceneManager db = new SceneManager();

        button_home.setOnAction(actionEvent -> db.changeScene(actionEvent,"/interfaces/logged-in.fxml",
                "Welcome!"));

        button_logout.setOnAction(actionEvent -> db.changeScene(actionEvent, "/interfaces/login.fxml",
                "Login!"));

        button_switch.setOnAction(actionEvent -> img_switch.setImage(gs.prepareImage()));

    }
        Image myImg_switch;
    public void setPower(){
        if(gate.isOpen()){
            myImg_switch=new Image(getClass().getResourceAsStream("/images/switch_on.png"));
        } else {
            myImg_switch=new Image(getClass().getResourceAsStream("/images/switch_off.png"));
        }
        if(this.img_switch!=null) {
            this.img_switch.setImage(myImg_switch);
        }
    }
}
