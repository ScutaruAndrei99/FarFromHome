package repository;

import constructors.Television;

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
    public Television TVStatus(){
        try{
            Television tv = null;
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM television");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                tv = new Television(
                    rs.getInt("idTV"),
                    rs.getInt("ChannelPost"),
                    rs.getString("ChannelName"),
                    rs.getBoolean("Power")
                );
            }
            return tv;
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

    public boolean updateChannel(Television tv){
        try{PreparedStatement statement = connection.prepareStatement("UPDATE television SET ChannelPost = ?, ChannelName = ?, Power = ? WHERE idTV = 3");
            statement.setInt(1, tv.getChannelPost());
            statement.setString(2, tv.getChannelName());
            statement.setBoolean(3, tv.isPower());

            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        }

    }

    public int WhatChannelPostIs(String ChannelName){
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT ChannelPost1 FROM channel WHERE ChannelName1 = ?");

            statement.setString(1,ChannelName); //Seteaza valoarea parametrului
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                int post = rs.getInt("ChannelPost1"); // Extrage valoarea coloanei "ChannelPost1"
                return post;
            } else {
                System.out.println("Nu a fost gasit niciun rand care sa corespunda criteriilor");
                return -1;
            }
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        }
    }


}
