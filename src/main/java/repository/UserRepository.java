package repository;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
            SqlConfig.closeDataBaseConnection();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
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
            SqlConfig.closeDataBaseConnection();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("3");
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
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
            SqlConfig.closeDataBaseConnection();
            return users;
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
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
            SqlConfig.closeDataBaseConnection();
            return email;
        }catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        }
    }
    public Map<String, String> accountsCheck() {
        Connection connection = SqlConfig.getDataBaseConnectionAccount();
        try {
            Map<String, String> accounts;
            accounts = new LinkedHashMap<>();
            PreparedStatement statement = connection.prepareStatement("SELECT username, password FROM accounts");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String user = rs.getString("username");
                String pass = rs.getString("password");
                accounts.put(user, pass);
            }
            SqlConfig.closeDataBaseConnection();
            return accounts;
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        }
    }
}
