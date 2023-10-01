package repository;

import model.Elevator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ElevatorRepository {
    public ElevatorRepository(){SqlConfig.getDataBaseConnection();}



    public Elevator findALL(){
        Connection connection = SqlConfig.getDataBaseConnection();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM elevator");
            ResultSet rs = statement.executeQuery();
            Elevator elevator =null;
            if(rs.next()){
                elevator = new Elevator(
                        rs.getInt("idElevator"),
                        rs.getInt("Floor"),
                        rs.getBoolean("Doors"),
                        rs.getBoolean("Used")
                        );
            }
            System.out.println(elevator);
            return elevator;
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        } finally {
            SqlConfig.closeDataBaseConnection();
        }
    }

    public void updateElevator(Elevator elevator) {
        Connection connection = SqlConfig.getDataBaseConnection();
        try{
            PreparedStatement statement = connection.prepareStatement("UPDATE elevator SET Floor =?," +
                    "Doors =?, Used =? WHERE idElevator =7");
            statement.setInt(1,elevator.getFloor());
            statement.setBoolean(2,elevator.isDoors());
            statement.setBoolean(3, elevator.isUsed());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        } finally {
            SqlConfig.closeDataBaseConnection();
        }
    }
}
