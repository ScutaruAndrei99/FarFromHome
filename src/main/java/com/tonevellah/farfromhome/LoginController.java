package com.tonevellah.farfromhome;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button button_login;
    @FXML
    private Button button_sign_up;
    @FXML
    private TextField tf_username;
    @FXML
    private PasswordField pf_password;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        DBUtils db= new DBUtils();

        button_login.setOnAction(event -> {

            db.loginUser(event, tf_username.getText(), pf_password.getText());
            db.changeScene(event, "/interfaces/logged-in.fxml","Logged");
        });

        button_sign_up.setOnAction(event -> db.changeScene(event, "/interfaces/register.fxml", "Register your account"));

    }
}