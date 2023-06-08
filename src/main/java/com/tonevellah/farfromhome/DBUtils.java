package com.tonevellah.farfromhome;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import repository.CentralRepository;
import repository.SqlConfig;
import service.CentralService;

import java.io.IOException;
import java.sql.*;


public class DBUtils {


    public static void changeScene(ActionEvent event, String fxmlFile, String title) {
        Parent root=null;
            try{
                FXMLLoader loader=new FXMLLoader(DBUtils.class.getResource(fxmlFile));
                root = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

        Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void lightScene(ActionEvent event, String fxmlFile) {
        Parent root=null;
        try{
            FXMLLoader loader=new FXMLLoader(DBUtils.class.getResource(fxmlFile));
            root = loader.load();
            LightRoomInterface lightroom=loader.getController();
            lightroom.setPower();
        } catch (IOException e){
            e.printStackTrace();
        }

        Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Light");
        stage.setScene(new Scene(root));
        stage.show();
    }
    public static void gateScene(ActionEvent event, String fxmlFile) {
        Parent root=null;
        try{
            FXMLLoader loader=new FXMLLoader(DBUtils.class.getResource(fxmlFile));
            root = loader.load();
            GateInterface gate=loader.getController();
            gate.setPower();
        } catch (IOException e){
            e.printStackTrace();
        }
        Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Gate");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void TVScene(ActionEvent event, String fxmlFile) {
        Parent root=null;
        try{
            FXMLLoader loader=new FXMLLoader(DBUtils.class.getResource(fxmlFile));
            root = loader.load();
        } catch (IOException e){
            e.printStackTrace();
        }
        Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("TV");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void EspressorScene(ActionEvent event, String fxmlFile) {
        Parent root=null;
        try{
            FXMLLoader loader=new FXMLLoader(DBUtils.class.getResource(fxmlFile));
            root = loader.load();
        } catch (IOException e){
            e.printStackTrace();
        }
        Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Espressor");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void CentralScene(ActionEvent event, String fxmlFile) {
        Parent root=null;
        try{
            FXMLLoader loader=new FXMLLoader(DBUtils.class.getResource(fxmlFile));
            root = loader.load();
            CentralInterface central=loader.getController();
            CentralService cs=new CentralService();
            String temperature = String.valueOf(cs.readTemperature());
            central.text_temperatureSet.setText(temperature);
        } catch (IOException e){
            e.printStackTrace();
        }
        Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Central");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void ElevatorScene(ActionEvent event, String fxmlFile) {
        Parent root=null;
        try{
            FXMLLoader loader=new FXMLLoader(DBUtils.class.getResource(fxmlFile));
            root = loader.load();
        } catch (IOException e){
            e.printStackTrace();
        }
        Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Elevator");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void CurtainsScene(ActionEvent event, String fxmlFile) {
        Parent root=null;
        try{
            FXMLLoader loader=new FXMLLoader(DBUtils.class.getResource(fxmlFile));
            root = loader.load();
        } catch (IOException e){
            e.printStackTrace();
        }
        Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Curtains");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void VacuumScene(ActionEvent event, String fxmlFile) {
        Parent root=null;
        try{
            FXMLLoader loader=new FXMLLoader(DBUtils.class.getResource(fxmlFile));
            root = loader.load();
        } catch (IOException e){
            e.printStackTrace();
        }
        Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Vacuum");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void registerUser(ActionEvent event, String username, String first_name, String last_name, String password, String email) {
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        PreparedStatement psCheckEmailExist;
        ResultSet resultSet = null;
        ResultSet rs;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = SqlConfig.getDataBaseConnectionAccount();
            psCheckUserExists = connection.prepareStatement("SELECT username FROM accounts WHERE username = ?");
            psCheckUserExists.setString(1,username);
            resultSet = psCheckUserExists.executeQuery();

            psCheckEmailExist = connection.prepareStatement("SELECT email FROM accounts WHERE email = ?");
            psCheckEmailExist.setString(1,email);
            rs = psCheckEmailExist.executeQuery();

            if (resultSet.isBeforeFirst()) {
                System.out.println("User already exists!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You cannot use this username.");
                alert.show();
            } else if (rs.isBeforeFirst()) {
                System.out.println("Email already exists!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You cannot use this email.");
                alert.show();
            } else {
                psInsert = connection.prepareStatement("INSERT INTO accounts (username, first_name, last_name, password, email) VALUES (?,?,?,?,?)");
                psInsert.setString(1,username);
                psInsert.setString(2,first_name);
                psInsert.setString(3,last_name);
                psInsert.setString(4,password);
                psInsert.setString(5,email);
                psInsert.executeUpdate();

                changeScene(event, "/interfaces/logged-in.fxml", "Welcome!");
            }
        } catch(ClassNotFoundException | SQLException exception) {
            System.out.println("Repository-ul nu a putut fi initializat");
            exception.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (psCheckUserExists != null) {
                try {
                    psCheckUserExists.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (psInsert != null) {
                try {
                    psInsert.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void loginUser(ActionEvent event, String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement =null ;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = SqlConfig.getDataBaseConnectionAccount();
            preparedStatement = connection.prepareStatement("SELECT password FROM accounts WHERE username = ?");
            preparedStatement.setString(1,username);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                System.out.println("User not fount in the system!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("User not fount in the system!");
                alert.show();
                throw new RuntimeException(("User not fount in the system!"));
            } else {
                while (resultSet.next()) {
                    String retrievedPassword = resultSet.getString("password");

                    if (retrievedPassword.equals(password)) {
                        changeScene(event, "/interfaces/logged-in.fxml","Welcome!");
                    } else {
                        System.out.println("Password did not match!");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Password did not match!");
                        alert.show();
                        throw new RuntimeException(("Password did not match!"));
                    }
                }
            }
        } catch(ClassNotFoundException | SQLException exception) {
            System.out.println("Repository-ul nu a putut fi initializat");
            exception.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                }catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}