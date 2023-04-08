package org.example;

import org.example.entity.Client;
import org.example.services.ClientService;
import org.example.services.Database;
import org.example.services.FlywayMigration;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        new FlywayMigration().flywayMigration();

        Database database = Database.getInstance();
        Connection conn = database.getConnection();

 //add new clients
        try {
            System.out.println(new ClientService().create("Ivan"));
            System.out.println(new ClientService().create("Jack"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



//get by id
    System.out.println(new ClientService().getById(4l));


//delete by id
    new ClientService().deleteById(2l);
//rename client
    new ClientService().setName(3l,"Eliot");

// read all clients
        try {
            List<Client> clients = new ClientService().listAll();
            System.out.println(clients.toString());
            System.out.println("----");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
