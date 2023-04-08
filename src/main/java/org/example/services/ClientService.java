package org.example.services;

import org.example.entity.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {


    public long create(String name) throws SQLException {

        long id = 0;
        //open connection
        Database database = Database.getInstance();
        Connection conn = database.getConnection();
        //add new client
        PreparedStatement statement;
        try {
            statement = conn.prepareStatement("INSERT INTO client (name) VALUES (?)");
            statement.setString(1, name);
            statement.addBatch();
            statement.executeBatch();
            statement.close();
            //read what id add to new client
            Statement st = conn.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT id FROM client WHERE name = '"+ name + "'");
            while(resultSet.next()){
                id = resultSet.getInt("id");
            }
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }


    public String getById(long id){
        String name = "";
        //open connection
        Database database = Database.getInstance();
        Connection conn = database.getConnection();

        Statement statement;
        try {
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT name FROM client WHERE id = "+(int)id);
            while(rs.next()){
                name = rs.getString("name");
            }
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return name;
    }

    public void setName(long id, String name){
        //open connection
        Database database = Database.getInstance();
        Connection conn = database.getConnection();

        PreparedStatement statement;
        try {
            statement = conn.prepareStatement("UPDATE client SET name = ? WHERE id = ?");
            statement.setString(1, name);
            statement.setInt(2,(int) id);
            statement.addBatch();
            statement.executeBatch();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void deleteById(long id){
        //open connection
        Database database = Database.getInstance();
        Connection conn = database.getConnection();

        Statement statement;
        try {
            statement = conn.createStatement();
            statement.executeUpdate("DELETE FROM client WHERE id = "+(int)id);
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }a


    public List<Client> listAll() throws SQLException {
        List<Client> clientList = new ArrayList<>();
        //open connection
        Database database = Database.getInstance();
        Connection conn = database.getConnection();
        String sql = "SELECT id, name FROM  client";
        Statement statement;
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //send querry
        ResultSet rs;
        try {
            rs = statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        while (rs.next()){

            int id = rs.getInt("id");
            String name = rs.getString("name");
            clientList.add(new Client(id, name));
        }
        statement.close();
        return clientList;

    }



}
