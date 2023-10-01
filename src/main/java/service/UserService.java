package service;

import model.User;
import repository.UserRepository;

public class UserService {
    UserRepository ur= new UserRepository();

    public User checkUsernameValability(String user){
        return ur.findUserByUsername(user);
    }
    public User checkEmailValability(String email) {
        return ur.findEmailByEmail(email);
    }
    public User findUserByUsernameAndPassword(String username, String password) {
        return ur.findUserByUserNameAndPassword(username,password);
    }
    public void createAccount(String username, String first_name,
                              String last_name, String password, String email){
        User userN = new User.UserBuilder().userName(username).firstName(first_name).last_name(last_name)
                .password(password).email(email).build();
        ur.createUser(userN);
    }
    public boolean checkImputFields(String username, String firstName, String lastName, String password,
                                    String retypePassword, String email, String retypeEmail) {
        if (username != null && firstName != null && lastName != null && password != null && retypePassword != null &&
        email != null && retypeEmail != null){
            return true;
        }
        return false;
    }
    public boolean checkCompatibilityPasswordAndRetype(String password, String retypePassword) {
        return password.trim().equalsIgnoreCase(retypePassword);
    }
    public boolean checkCompatibilityEmailAndRetype(String email, String retypeEmail) {
        return email.trim().equalsIgnoreCase(retypeEmail.trim());
    }
}
