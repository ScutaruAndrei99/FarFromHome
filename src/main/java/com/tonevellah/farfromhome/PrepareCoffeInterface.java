package com.tonevellah.farfromhome;

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

        DBUtils db = new DBUtils();
        EspressorService es = new EspressorService();

        button_back.setOnAction(event -> {
            db.espressorScene(event,"/interfaces/espressor.fxml");
            es.resetPrepareSet();
        });

        button_minus_sugar.setOnAction(event -> {
            es.minusSugar();
            text_sugar.setText(es.readSugarSet());
        });

        button_plus_sugar.setOnAction(event -> {
            es.plusSugar();
            text_sugar.setText(es.readSugarSet());
        });

        button_minus_quantity.setOnAction(event -> {
            es.minusQuantity();
            text_quantity.setText(es.readQuantitySet());
        });

        button_plus_quantity.setOnAction(event -> {
            es.plusQuantity();
            text_quantity.setText(es.readQuantitySet());
        });

        button_minus_intensity.setOnAction(event -> {
            es.minusIntensity();
            text_intensity.setText(es.readIntensitySet());
        });

        button_plus_intensity.setOnAction(event -> {
            es.plusIntensity();
            text_intensity.setText(es.readIntensitySet());
        });

        button_start.setOnAction(event -> {
            es.prepareCoffee();
            es.resetPrepareSet();
            db.espressorScene(event,"/interfaces/espressor.fxml");
        });
    }
}
