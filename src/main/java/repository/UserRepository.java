package repository;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public UserRepository() {SqlConfig.getDataBaseConnectionAccount();}

    public boolean updateUser(User user) {
        Connection connection = SqlConfig.getDataBaseConnectionAccount();
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE accounts SET username=?, " +
                    "first_name=?, last_name=?, password=?, email=?");
            statement.setString(1,user.getUserName());
            statement.setString(2,user.getFirst_name());
            statement.setString(3,user.getLast_name());
            statement.setString(4,user.getPassword());
            statement.setString(5,user.getEmail());
            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        } finally {
            SqlConfig.closeDataBaseConnection();
        }
    }

    public boolean createUser(User user) {
        Connection connection = SqlConfig.getDataBaseConnectionAccount();
        try{
            PreparedStatement statement=connection.prepareStatement("INSERT INTO accounts (username," +
                    "first_name, last_name, password, email) VALUES (?,?,?,?,?) ");
            statement.setString(1,user.getUserName());
            statement.setString(2,user.getFirst_name());
            statement.setString(3,user.getLast_name());
            statement.setString(4, user.getPassword());
            statement.setString(5,user.getEmail());
            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("3");
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        } finally {
            SqlConfig.closeDataBaseConnection();
        }
    }

    public List<String> findAllUsers(){
        Connection connection = SqlConfig.getDataBaseConnectionAccount();
        try{
            List<String> users = new ArrayList<>();
            PreparedStatement statement=connection.prepareStatement("SELECT username FROM accounts");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String user= rs.getString("username");
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        } finally {
            SqlConfig.closeDataBaseConnection();
        }
    }

     public User findUserByUserNameAndPassword(String username, String password) {
         Connection connection = SqlConfig.getDataBaseConnectionAccount();
         User user= null;
         try {
             PreparedStatement statement = connection.prepareStatement("SELECT username, " +
                     "first_name, last_name, email FROM accounts WHERE username=? AND password=?");
             statement.setString(1,username);
             statement.setString(2,password);

             ResultSet rs = statement.executeQuery();
             if (rs.next()){
                 user = new User.UserBuilder().userName(rs.getString(1)).firstName(rs.getString(2))
                         .last_name(rs.getString(3)).email(rs.getString(4)).build();
             }
             return user;
         } catch (SQLException e) {
             System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
             throw new RuntimeException(e);
         } finally {
             SqlConfig.closeDataBaseConnection();
         }
     }
     public User findUserByUsername(String username){
         Connection connection = SqlConfig.getDataBaseConnectionAccount();
         User user= null;
         try {
             PreparedStatement statement = connection.prepareStatement("SELECT username " +
                     " FROM accounts WHERE username=? ");
             statement.setString(1,username);

             ResultSet rs = statement.executeQuery();
             if (rs.next()){
                 user = new User.UserBuilder().userName(rs.getString(1)).build();
             }
             return user;
         } catch (SQLException e) {
             System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
             throw new RuntimeException(e);
         } finally {
             SqlConfig.closeDataBaseConnection();
         }
     }
     public User findEmailByEmail(String email){
        Connection connection = SqlConfig.getDataBaseConnectionAccount();
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT email FROM accounts WHERE email=?");
            statement.setString(1,email);

            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                user = new User.UserBuilder().email(rs.getString(1)).build();
//                        user.UserBuilder().build();
            }
            return user;
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        } finally {
            SqlConfig.closeDataBaseConnection();
        }
     }
    public List<String> findAllEmail(){
        Connection connection = SqlConfig.getDataBaseConnectionAccount();
        try{
            List<String> email = new ArrayList<>();
            PreparedStatement statement=connection.prepareStatement("SELECT email FROM accounts");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String mail = rs.getString("email");
                email.add(mail);
            }
            return email;
        }catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        } finally {
            SqlConfig.closeDataBaseConnection();
        }
    }
}
