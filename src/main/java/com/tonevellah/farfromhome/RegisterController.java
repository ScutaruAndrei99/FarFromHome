package com.tonevellah.farfromhome;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML
    private Button button_loginR;
    @FXML
    private Button button_sign_upR;
    @FXML
    private TextField tf_usernameR;
    @FXML
    private TextField tf_firstNameR;
    @FXML
    private TextField tf_lastNameR;
    @FXML
    private PasswordField pf_passwordR;
    @FXML
    private PasswordField pf_retypePasswordR;
    @FXML
    private TextField tf_emailR;
    @FXML
    private TextField tf_retypeEmailR;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        DBUtils db = new DBUtils();

        button_sign_upR.setOnAction(event -> {
            if (!tf_usernameR.getText().trim().isEmpty() && !tf_firstNameR.getText().trim().isEmpty() && !tf_lastNameR.getText().trim().isEmpty() && !pf_passwordR.getText().trim().isEmpty() && !pf_retypePasswordR.getText().trim().isEmpty() && !tf_emailR.getText().trim().isEmpty() && !tf_retypeEmailR.getText().trim().isEmpty()) {
                if (!pf_passwordR.getText().equals(pf_retypePasswordR.getText())) {
                    System.out.println("Check to write the same password");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Check to write the same password");
                    alert.show();
                } else if (!tf_emailR.getText().equals(tf_retypeEmailR.getText())){
                    System.out.println("Check to write the same email");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Check to write the same email");
                    alert.show();
                } else {
                    db.registerUser(event, tf_usernameR.getText(),tf_firstNameR.getText(), tf_lastNameR.getText(), pf_passwordR.getText(), tf_emailR.getText());
                }
            } else {
                System.out.println("Please fill in all information");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please fill in all information to sing up!");
                alert.show();
            }
        });

        button_loginR.setOnAction(event -> db.changeScene(event, "/interfaces/login.fxml", "Login!"));
    }

}