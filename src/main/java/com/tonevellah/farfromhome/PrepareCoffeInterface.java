package com.tonevellah.farfromhome;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import service.EspressorService;

import java.net.URL;
import java.util.ResourceBundle;

public class PrepareCoffeInterface implements Initializable {
    @FXML
    private Button button_back;
    @FXML
    private Button button_start;
    @FXML
    private Button button_minus_sugar;
    @FXML
    private Button button_plus_sugar;
    @FXML
    private Button button_minus_quantity;
    @FXML
    private Button button_plus_quantity;
    @FXML
    private Button button_minus_intensity;
    @FXML
    private Button button_plus_intensity;
    @FXML
    public Text text_sugar;
    @FXML
    public Text text_quantity;
    @FXML
    public Text text_intensity;

    public void initialize (URL url, ResourceBundle resourceBundle){
        button_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.EspressorScene(event,"/interfaces/espressor.fxml");
            }
        });
        button_minus_sugar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                EspressorService.minusSugarSet();
                text_sugar.setText(EspressorService.SugarSet());
            }
        });
        button_plus_sugar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                EspressorService.plusSugarSet();
                text_sugar.setText(EspressorService.SugarSet());
            }
        });
        button_minus_quantity.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                EspressorService.minusQuantitySet();
                text_quantity.setText(EspressorService.QuantitySet());
            }
        });
        button_plus_quantity.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                EspressorService.plusQuantitySet();
                text_quantity.setText(EspressorService.QuantitySet());
            }
        });
        button_minus_intensity.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                EspressorService.minusIntensitySet();
                text_intensity.setText(EspressorService.IntensitySet());
            }
        });
        button_plus_intensity.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                EspressorService.plusIntensitySet();
                text_intensity.setText(EspressorService.IntensitySet());
            }
        });
        button_start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                EspressorService.prepareCoffeFinal();
                EspressorService.resetPrepareSetFinal();
                DBUtils.EspressorScene(event,"/interfaces/espressor.fxml");
            }
        });
    }
}
