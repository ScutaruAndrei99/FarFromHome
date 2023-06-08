package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConfig {
    private static Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/proiectjava";
    private static final String URL2 ="jdbc:mysql://localhost:3306/accountffh";
    private static final String USER = "root";
    private static final String PASSWORD = "1234567";

    public static Connection getDataBaseConnection() {
        try {
            if(connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Successfully connected to database!");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return connection;
    }
    public static Connection getDataBaseConnectionAccount(){
        try {
            if(connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL2, USER, PASSWORD);
                System.out.println("Successfully connected to database!");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return connection;
    }

    public static void closeDataBaseConnection() {
        try {
            if(connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection successfully closed! Bye Bye!");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private SqlConfig() {}
}
