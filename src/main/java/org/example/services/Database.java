package org.example.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Database instance = new Database();      //singleton instance
    private Connection connection;
    private static final String url = "jdbc:h2:./MyDB"; // JDBC URL for connect to H2 Database


    private Database() {
        try {
            // Load driver JDBC
            Class.forName("org.h2.Driver");
            //connect to DB
            connection = DriverManager.getConnection(url);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Database getInstance() {
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }



}
