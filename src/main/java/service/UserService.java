package service;


import javafx.scene.control.Alert;
import model.User;
import repository.UserRepository;

import java.util.List;
import java.util.Map;

public class UserService {
    UserRepository ur= new UserRepository();

    public boolean checkUsernameValability(String user){
        List<String> usernameList= ur.findAllUsers();
        for (String search : usernameList) {
            if (search.equals(user)) {
                System.out.println("User already exists!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You cannot use this username.");
                alert.show();
                return true;
            }
        }
        return false;
    }
    public boolean checkEmailValability(String email) {
        List<String> emailList=ur.findAllEmail();
        for (String search : emailList) {
            if (search.equals(email)){
                System.out.println("Email already exists!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You cannot use this email.");
                alert.show();
                return true;
            }
        }
        return false;
    }

    public void createAccount(String username, String first_name,
                              String last_name, String password, String email){
        User userN = new User(username, first_name, last_name, password, email);
        ur.createUser(userN);
    }
    public boolean checkMatchAccount(String username, String password) {
        Map<String, String> accounts = ur.accountsCheck();

        if (accounts.containsKey(username)) {
            // Dacă username există, verificăm dacă parola corespunde
            String storedPassword = accounts.get(username);
            if (password.equals(storedPassword)) {
                // Parola corespunde
                return true;
            }
        }
        System.out.println("Username or password did not match!");
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Username or password did not match!");
        alert.show();
        // Username sau parolă incorecte
        return false;
    }
}
