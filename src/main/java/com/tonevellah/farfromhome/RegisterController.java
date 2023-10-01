package com.tonevellah.farfromhome;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import service.UserService;


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

        SceneManager db = new SceneManager();
        UserService us=new UserService();

        button_sign_upR.setOnAction(event -> {
            if (us.checkImputFields(tf_usernameR.getText(),tf_firstNameR.getText(), tf_lastNameR.getText(),
                    pf_passwordR.getText(), pf_retypePasswordR.getText(), tf_emailR.getText(),
                    tf_retypeEmailR.getText())) {

                if (!us.checkCompatibilityPasswordAndRetype(pf_passwordR.getText(), pf_retypePasswordR.getText())){
                    prepareAlert("Check to write the same password");
                }
                if (!us.checkCompatibilityEmailAndRetype(tf_emailR.getText(), tf_retypeEmailR.getText())){
                    prepareAlert("Check to write the same email");
                } else {
                    if (us.checkUsernameValability(tf_usernameR.getText()) == null) {
                        if (us.checkEmailValability(tf_emailR.getText()) == null) {
                            us.createAccount(tf_usernameR.getText(), tf_firstNameR.getText(), tf_lastNameR.getText(),
                                    pf_passwordR.getText(), tf_emailR.getText());
                            db.registerUser(event);
                        }else {
                            prepareAlert("You cannot use this email.");
                        }
                    }else {
                        prepareAlert("You cannot use this username.");
                    }
                }
            } else {
                prepareAlert("Complete all the fields before sing up");
            }
        });

        button_loginR.setOnAction(event -> db.changeScene(event, "/interfaces/login.fxml", "Login!"));
    }

    public void prepareAlert (String text) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(text);
        alert.show();
    }

}