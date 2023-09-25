package repository;

import model.Central;

import java.sql.*;

public class CentralRepository {
    public CentralRepository() {
        SqlConfig.getDataBaseConnection();
    }


    public boolean updateCentral(Central c) {
        Connection connection = SqlConfig.getDataBaseConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE central SET Temperature = ?, Power = ? WHERE idCentral = 2");
            statement.setFloat(1, c.getTemperature());
            statement.setBoolean(2, c.isPower());
            int affectedRows = statement.executeUpdate();
            SqlConfig.closeDataBaseConnection();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        }
    }


    public Central findById(int idCentral) {
        Connection connection = SqlConfig.getDataBaseConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM central WHERE idCentral = ?");
            statement.setInt(1, idCentral);
            ResultSet rs = statement.executeQuery();

            Central c = null;
            if (rs.next()) {
                c = new Central(
                        rs.getInt("idCentral"),
                        rs.getFloat("Temperature"),
                        rs.getBoolean("Power")
                );
            }
            SqlConfig.closeDataBaseConnection();
            return c;
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        }
    }
}
