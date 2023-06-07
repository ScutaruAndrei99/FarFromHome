package com.tonevellah.farfromhome;

import repository.LightRepository;
import constructors.Light;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import service.LightService;

import java.net.URL;
import java.util.ResourceBundle;

public class LightRoomInterface implements Initializable {

    LightRepository lr=new LightRepository();
    LightService ls=new LightService();
    Light light=lr.findById(4);
    @FXML
    private Button button_logout;
    @FXML
    private Button button_bathroom;
    @FXML
    private ImageView img_bathroom;
    @FXML
    private Button button_bedroom;
    @FXML
    public ImageView img_bedroom;
    @FXML
    private Button button_kitchen;
    @FXML
    public ImageView img_kitchen;
    @FXML
    private Button button_hall;
    @FXML
    public ImageView img_hall;
    @FXML
    private Button button_livingroom;
    @FXML
    public ImageView img_livingroom;
    @FXML
    private Button button_dressing;
    @FXML
    public ImageView img_dressing;
    @FXML
    private Button button_boiler;
    @FXML
    public ImageView img_boiler;
    @FXML
    private Button button_home;

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

        button_bathroom.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                img_bathroom.setImage(ls.prepareBathroom());
            }
        });

        button_bedroom.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                img_bedroom.setImage(ls.prepareBedroom());
            }
        });

        button_kitchen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                img_kitchen.setImage(ls.prepareKitchen());
            }
        });

        button_hall.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                img_hall.setImage(ls.prepareHall());
            }
        });

        button_livingroom.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                img_livingroom.setImage(ls.prepareLivingroom());
            }
        });

        button_dressing.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                img_dressing.setImage(ls.prepareDressing());
            }
        });

        button_boiler.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                img_boiler.setImage(ls.prepareBoiler());
            }
        });
    }

    Image myImg_bathroom, myImg_bedroom, myImg_kitchen, myImg_hall, myImg_livingroom, myImg_dressing, myImg_boiler;

    public void setPower() {
        if (light.isBathroom()) {
            myImg_bathroom = new Image(getClass().getResourceAsStream("/images/lightbulb_on.png"));
        } else {
            myImg_bathroom = new Image(getClass().getResourceAsStream("/images/lightbulb_off.png"));
        }
        if(this.img_bathroom!=null) {
            this.img_bathroom.setImage(myImg_bathroom);
        }

        if (light.isBedroom()) {
            myImg_bedroom = new Image(getClass().getResourceAsStream("/images/lightbulb_on.png"));
        } else {
            myImg_bedroom = new Image(getClass().getResourceAsStream("/images/lightbulb_off.png"));
        }
        if(this.img_bedroom!=null) {
            this.img_bedroom.setImage(myImg_bedroom);
        }

        if (light.isKitchen()) {
            myImg_kitchen = new Image(getClass().getResourceAsStream("/images/lightbulb_on.png"));
        } else {
            myImg_kitchen = new Image(getClass().getResourceAsStream("/images/lightbulb_off.png"));
        }
        if(this.img_kitchen!=null) {
            this.img_kitchen.setImage(myImg_kitchen);
        }

        if (light.isHall()) {
            myImg_hall = new Image(getClass().getResourceAsStream("/images/lightbulb_on.png"));
        } else {
            myImg_hall = new Image(getClass().getResourceAsStream("/images/lightbulb_off.png"));
        }
        if(this.img_hall!=null) {
            this.img_hall.setImage(myImg_hall);
        }

        if (light.isLivingRoom()) {
            myImg_livingroom = new Image(getClass().getResourceAsStream("/images/lightbulb_on.png"));
        } else {
            myImg_livingroom = new Image(getClass().getResourceAsStream("/images/lightbulb_off.png"));
        }
        if(this.img_livingroom!=null) {
            this.img_livingroom.setImage(myImg_livingroom);
        }

        if (light.isDressing()) {
            myImg_dressing = new Image(getClass().getResourceAsStream("/images/lightbulb_on.png"));
        } else {
            myImg_dressing = new Image(getClass().getResourceAsStream("/images/lightbulb_off.png"));
        }
        if(this.img_dressing!=null) {
            this.img_dressing.setImage(myImg_dressing);
        }

        if (light.isBoiler()) {
            myImg_boiler = new Image(getClass().getResourceAsStream("/images/lightbulb_on.png"));
        } else {
            myImg_boiler = new Image(getClass().getResourceAsStream("/images/lightbulb_off.png"));
        }
        if(this.img_boiler!=null) {
            this.img_boiler.setImage(myImg_boiler);
        }
    }
}
