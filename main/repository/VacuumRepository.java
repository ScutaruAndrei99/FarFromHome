package repository;

import model.Vacuum;

import java.sql.*;

public class VacuumRepository {
    private Connection connection;
    public VacuumRepository() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectjava", "root", "1234567");
            this.connection = conn;
        } catch(ClassNotFoundException | SQLException exception) {
            System.out.println("Repository-ul nu a putut fi initializat");
            exception.printStackTrace();
        }
    }

    public Vacuum findById() {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM vacuum WHERE idVacuum=6");
            ResultSet rs = statement.executeQuery();

            Vacuum vacuum = null;
            if (rs.next()) {
                vacuum = new Vacuum(
                        rs.getInt("idVacuum"),
                        rs.getBoolean("Power")
                );
            }
            return vacuum;
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        }
    }

    public boolean updateVacuum(Vacuum vacuum) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE vacuum SET Power=? WHERE idVacuum=6");
            statement.setBoolean(1, vacuum.isPowerVacuum());
            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        }
    }
}
