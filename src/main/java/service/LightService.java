package service;

import constructors.Light;
import javafx.scene.image.Image;
import repository.LightRepository;

public class LightService {
    LightRepository lr=new LightRepository();
    Light light=lr.findById(4);
    public Image prepareBathroom(){
        Image myImg_bathroom;
        if (light.isBathroom()) {
            myImg_bathroom = new Image(getClass().getResourceAsStream("/images/lightbulb_off.png"));
            light.setBathroom(false);
            lr.updateLight(light);
        } else {
            myImg_bathroom = new Image(getClass().getResourceAsStream("/images/lightbulb_on.png"));
            light.setBathroom(true);
            lr.updateLight(light);
        }
        return myImg_bathroom;
    }

    public Image prepareBedroom(){
        Image myImg_bedroom;
        if (light.isBedroom()) {
            myImg_bedroom = new Image(getClass().getResourceAsStream("/images/lightbulb_off.png"));
            light.setBedroom(false);
            lr.updateLight(light);
        } else {
            myImg_bedroom = new Image(getClass().getResourceAsStream("/images/lightbulb_on.png"));
            light.setBedroom(true);
            lr.updateLight(light);
        }
        return myImg_bedroom;
    }

    public Image prepareKitchen(){
        Image myImg_kitchen;
        if (light.isKitchen()) {
            myImg_kitchen = new Image(getClass().getResourceAsStream("/images/lightbulb_off.png"));
            light.setKitchen(false);
            lr.updateLight(light);
        } else {
            myImg_kitchen = new Image(getClass().getResourceAsStream("/images/lightbulb_on.png"));
            light.setKitchen(true);
            lr.updateLight(light);
        }
        return myImg_kitchen;
    }

    public Image prepareHall(){
        Image myImg_hall;
        if (light.isHall()) {
            myImg_hall = new Image(getClass().getResourceAsStream("/images/lightbulb_off.png"));
            light.setHall(false);
            lr.updateLight(light);
        } else {
            myImg_hall = new Image(getClass().getResourceAsStream("/images/lightbulb_on.png"));
            light.setHall(true);
            lr.updateLight(light);
        }
        return myImg_hall;
    }

    public Image prepareLivingroom(){
        Image myImg_livingroom;
        if (light.isLivingRoom()) {
            myImg_livingroom = new Image(getClass().getResourceAsStream("/images/lightbulb_off.png"));
            light.setLivingRoom(false);
            lr.updateLight(light);
        } else {
            myImg_livingroom = new Image(getClass().getResourceAsStream("/images/lightbulb_on.png"));
            light.setLivingRoom(true);
            lr.updateLight(light);
        }
        return myImg_livingroom;
    }

    public Image prepareDressing(){
        Image myImg_dressing;
        if (light.isDressing()) {
            myImg_dressing = new Image(getClass().getResourceAsStream("/images/lightbulb_off.png"));
            light.setDressing(false);
            lr.updateLight(light);
        } else {
            myImg_dressing = new Image(getClass().getResourceAsStream("/images/lightbulb_on.png"));
            light.setDressing(true);
            lr.updateLight(light);
        }
        return myImg_dressing;
    }

    public Image prepareBoiler(){
        Image myImg_boiler;
        if (light.isBoiler()) {
            myImg_boiler = new Image(getClass().getResourceAsStream("/images/lightbulb_off.png"));
            light.setBoiler(false);
            lr.updateLight(light);
        } else {
            myImg_boiler = new Image(getClass().getResourceAsStream("/images/lightbulb_on.png"));
            light.setBoiler(true);
            lr.updateLight(light);
        }
        return myImg_boiler;
    }
}
