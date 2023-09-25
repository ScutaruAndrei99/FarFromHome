package com.tonevellah.farfromhome;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import service.CentralService;
import service.TVService;

import java.io.IOException;


public class DBUtils {

    public void changeScene(ActionEvent event, String fxmlFile, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void lightScene(ActionEvent event, String fxmlFile) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            LightRoomInterface lightroom = loader.getController();
            lightroom.setPower();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Light");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void gateScene(ActionEvent event, String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            GateInterface gate = loader.getController();
            gate.setPower();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Gate");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tvScene(ActionEvent event, String fxmlFile) {
        try{
            FXMLLoader loader=new FXMLLoader(DBUtils.class.getResource(fxmlFile));
             Parent root = loader.load();
            TVInterface tv =loader.getController();
            TVService ts = new TVService();
            tv.powerPrepare(ts.PowerStatus());
            Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("TV");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void espressorScene(ActionEvent event, String fxmlFile) {
        try{
            FXMLLoader loader=new FXMLLoader(DBUtils.class.getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Espressor");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void expressorPrepareCoffee(ActionEvent event, String fxmlFile){
        try{
            FXMLLoader loader=new FXMLLoader(DBUtils.class.getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Prepare Coffee");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void centralScene(ActionEvent event, String fxmlFile) {
        try{
            FXMLLoader loader=new FXMLLoader(DBUtils.class.getResource(fxmlFile));
            Parent root = loader.load();
            CentralInterface central=loader.getController();
            CentralService cs=new CentralService();
            String temperature = String.valueOf(cs.readTemperature());
            central.text_temperatureSet.setText(temperature);
            Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Central");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void elevatorScene(ActionEvent event, String fxmlFile) {
        try{
            FXMLLoader loader=new FXMLLoader(DBUtils.class.getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Elevator");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public void curtainsScene(ActionEvent event, String fxmlFile) {
        try{
            FXMLLoader loader=new FXMLLoader(DBUtils.class.getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Curtains");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void vacuumScene(ActionEvent event, String fxmlFile) {
        try{
            FXMLLoader loader=new FXMLLoader(DBUtils.class.getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Vacuum");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void registerUser(ActionEvent event) {
        changeScene(event, "/interfaces/logged-in.fxml", "Welcome!");

    }
}