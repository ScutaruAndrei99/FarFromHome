package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TVRepository {
    public TVRepository() {SqlConfig.getDataBaseConnection();}
    private Connection connection=SqlConfig.getDataBaseConnection();

    public List<String> TVlist() {
        try {
            List<String> TVlist = new ArrayList<>();
            PreparedStatement statement = connection.prepareStatement("SELECT ChannelName1 FROM channel");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                TVlist.add(rs.getString("ChannelName1"));
            }
            return TVlist;
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        }
    }
    public String Channel(){
        try{
            String channel = null;
            PreparedStatement statement = connection.prepareStatement("SELECT ChannelName FROM television");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                channel= rs.getString("ChannelName");
            }
            return channel;
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        }
    }


}
