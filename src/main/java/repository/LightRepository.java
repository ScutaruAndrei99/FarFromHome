package repository;

import constructors.Light;

import java.sql.*;

public class LightRepository {

    public LightRepository() {
        SqlConfig.getDataBaseConnection();
    }
    public Light findById(int idLight) {
        String sql ="SELECT * FROM light WHERE idLight = ?";
        Connection connection = SqlConfig.getDataBaseConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,idLight);
            ResultSet rs = statement.executeQuery();

            Light light = null;
            if (rs.next()) {
                light = new Light(
                        rs.getInt("idLight"),
                        rs.getBoolean("Bathroom"),
                        rs.getBoolean("Bedroom"),
                        rs.getBoolean("Kitchen"),
                        rs.getBoolean("Hall"),
                        rs.getBoolean("LivingRoom"),
                        rs.getBoolean("Dressing"),
                        rs.getBoolean("Boiler")
                );
            }
            return light;
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        }
    }
    public boolean updateLight(Light light) {
        Connection connection = SqlConfig.getDataBaseConnection();
        String sql= "UPDATE light SET Bathroom = ?, Bedroom = ?, Kitchen = ?, Hall = ?, LivingRoom = ?, Dressing = ?, Boiler = ? WHERE idLight = 4";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setBoolean(1, light.isBathroom());
            statement.setBoolean(2, light.isBedroom());
            statement.setBoolean(3, light.isKitchen());
            statement.setBoolean(4, light.isHall());
            statement.setBoolean(5, light.isLivingRoom());
            statement.setBoolean(6, light.isDressing());
            statement.setBoolean(7, light.isBoiler());
            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
