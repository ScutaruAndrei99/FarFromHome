package repository;

import constructors.Gate;

import java.sql.*;

public class GateRepository {
    public GateRepository(){
        SqlConfig.getDataBaseConnection();
    }

    public Gate findByID() {
        String sql ="SELECT * FROM gate WHERE idGate = 8";
        Connection connection = SqlConfig.getDataBaseConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            Gate gate = null;
            if(rs.next()){
                gate = new Gate(
                        rs.getInt("idGate"),
                        rs.getBoolean("Open"),
                        rs.getBoolean("Status")
                );
            }
            return gate;
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        }
    }
    public boolean update(Gate gate){
        Connection connection = SqlConfig.getDataBaseConnection();
        String sql= "UPDATE gate SET Open=?,Status=? WHERE idGate=8";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setBoolean(1,gate.isOpen());
            statement.setBoolean(2,gate.isStatus());
            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
