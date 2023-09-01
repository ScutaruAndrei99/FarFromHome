package repository;

import constructors.Espressor;
import constructors.PrepareCoffee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EspressorRepository {
    public EspressorRepository() {
        SqlConfig.getDataBaseConnection();
    }
    private Connection connection=SqlConfig.getDataBaseConnection();

    public List<Espressor> findAll() {
        try {
            List<Espressor> result = new ArrayList<>();

            PreparedStatement statement = connection.prepareStatement("SELECT idEspressor, ShotCoffe,ShotWater, ShotMilk, Sugar FROM espressor");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Espressor e = new Espressor(
                        rs.getLong("idEspressor"),
                        rs.getLong("ShotCoffe"),
                        rs.getLong("ShotWater"),
                        rs.getLong("ShotMilk"),
                        rs.getLong("Sugar")
                );
                result.add(e);
            }
            return result;
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        }
    }

    public PrepareCoffee findPrepare() {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT SugarSet, QuantitySet, IntensitySet, TypeCoffee FROM espressor");
            ResultSet rs = statement.executeQuery();

            PrepareCoffee prepare = null;
            if (rs.next()) {
                prepare = new PrepareCoffee(
                        rs.getInt("SugarSet"),
                        rs.getInt("QuantitySet"),
                        rs.getInt("IntensitySet"),
                        rs.getString("TypeCoffee")
                );
            }
            return prepare;
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        }
    }
    public boolean updatePrepare (PrepareCoffee prepare) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE espressor SET SugarSet = ?, QuantitySet = ?, IntensitySet = ?, TypeCoffee = ? WHERE idEspressor = 1");
            statement.setInt(1, prepare.getSugar());
            statement.setInt(2, prepare.getQuantity());
            statement.setInt(3, prepare.getIntensity());
            statement.setString(4,prepare.getTypeCoffee());

            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        }
    }

    public boolean update(Espressor er) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE espressor SET ShotCoffe = ?, ShotWater = ?, ShotMilk = ?, Sugar = ? WHERE idEspressor = 1");
            statement.setLong(1, er.getShotCoffe());
            statement.setLong(2, er.getShotWater());
            statement.setLong(3, er.getShotMilk());
            statement.setLong(4,er.getSugar());
            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        }
    }

    public boolean updateRefill() {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE espressor SET ShotCoffe = ?, ShotWater = ?, ShotMilk = ?, Sugar = ? WHERE idEspressor = 1");
            statement.setLong(1, 10);
            statement.setLong(2, 10);
            statement.setLong(3, 10);
            statement.setLong(4,10);
            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        }
    }

    public Espressor findById(int idEspressor) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT idEspressor, ShotCoffe, ShotWater, ShotMilk, Sugar FROM espressor WHERE idEspressor = ?");
            statement.setInt(1, idEspressor);
            ResultSet rs = statement.executeQuery();

            Espressor e = null;
            if (rs.next()) {
                e = new Espressor(
                        rs.getLong("idEspressor"),
                        rs.getLong("ShotCoffe"),
                        rs.getLong("ShotWater"),
                        rs.getLong("ShotMilk"),
                        rs.getLong("Sugar")
                );
            }
            return e;
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        }
    }
}
