package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private static Database instance = new Database();      //singleton instance
    private Connection connection;
    private static final String url = "jdbc:h2:./MyDB"; // JDBC URL for connect to H2 Database
//    private String username = "sa"; // user name
//    private String password = ""; // user pass

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

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void sendSQLExecute(String sql) throws SQLException {
//open connection
        Database database = Database.getInstance();
        Connection conn = database.getConnection();
//create statement
        Statement statement = conn.createStatement();
        statement.execute(sql);                             //send wrote file to H2 DB
//close connection
        statement.close();
        database.closeConnection();
    }

    public static void sendSQLExecuteUpdate(String sql) throws SQLException {
//open connection
        Database database = Database.getInstance();
        Connection conn = database.getConnection();
//create statement
        Statement statement = conn.createStatement();
        statement.executeUpdate(sql);                             //send wrote file to H2 DB
//close connection
        statement.close();
        database.closeConnection();
    }
}
