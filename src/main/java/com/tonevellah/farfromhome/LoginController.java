package com.tonevellah.farfromhome;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.User;
import service.UserService;

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
    private User loggedUser;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SceneManager db= new SceneManager();
        UserService us = new UserService();

        button_login.setOnAction(event -> {
            loggedUser=us.findUserByUsernameAndPassword(tf_username.getText(),pf_password.getText());
            if(loggedUser != null) {
                db.changeScene(event, "/interfaces/logged-in.fxml", "Logged");
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Username or password did not match!");
                alert.show();
            }

        });

        button_sign_up.setOnAction(event -> db.changeScene(event, "/interfaces/register.fxml",
                "Register your account"));

    }
}