package org.example.services;

import org.example.*;
import org.example.querries.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseQueryService {

    private static final String maxSalaryWorkerFilePath = "sql/find_max_salary_worker.sql";
    private static final String longestProjectFilePath = "sql/find_longest_project.sql";
    private static final String maxProjectsClientFilePath = "sql/find_max_projects_client.sql";
    private static final String youngestEldestWorkersFilePath = "sql/find_youngest_eldest_workers.sql";
    private static final String printProjectPricesFilePath = "sql/print_project_prices.sql";


public  List<FindMaxSalaryWorker> findMaxSalaryWorker() throws IOException, SQLException {

    List<FindMaxSalaryWorker> findMaxSalaryWorkerList = new ArrayList<>();
//read file with select command
    SQLFileReader sqlFileReader = new SQLFileReader();
    String querry = sqlFileReader.readFile(maxSalaryWorkerFilePath);

//open connection
    Database database = Database.getInstance();
    Connection conn = database.getConnection();
//create statement
    Statement statement = conn.createStatement();
    //send querry
    ResultSet rs = statement.executeQuery(querry);
        while (rs.next()){
            String name = rs.getString("name");
            int salary = rs.getInt("salary");
            findMaxSalaryWorkerList.add(new FindMaxSalaryWorker(name,salary));
        }

    return findMaxSalaryWorkerList;
    }

    public List<FindLongestProject> findLongestProjects() throws IOException, SQLException {

        List<FindLongestProject> findLongestProjectList = new ArrayList<>();
//read file with select command
        SQLFileReader sqlFileReader = new SQLFileReader();
        String querry = sqlFileReader.readFile(longestProjectFilePath);
//open connection
        Database database = Database.getInstance();
        Connection conn = database.getConnection();
//create statement
        Statement statement = conn.createStatement();
        //send querry
        ResultSet rs = statement.executeQuery(querry);
        while (rs.next()){
            int id = rs.getInt("id");
            int month_count = rs.getInt("project_time");
            findLongestProjectList.add(new FindLongestProject(id,month_count));
        }

        return findLongestProjectList;
    }

    public List<FindYoungestEldestWorkers> findYoungestEldestWorkers() throws IOException, SQLException{
        List<FindYoungestEldestWorkers> findYoungestEldestWorkersList = new ArrayList<>();
//read file with select command
        SQLFileReader sqlFileReader = new SQLFileReader();
        String querry = sqlFileReader.readFile(youngestEldestWorkersFilePath);
//open connection
        Database database = Database.getInstance();
        Connection conn = database.getConnection();
//create statement
        Statement statement = conn.createStatement();
        //send querry
        ResultSet rs = statement.executeQuery(querry);
        while (rs.next()){
            String type = rs.getString("type");
            String name = rs.getString("name");
            Date birthday = rs.getDate("birthday");
            findYoungestEldestWorkersList.add(new FindYoungestEldestWorkers(type,name,birthday));
        }
        return findYoungestEldestWorkersList;
    }


    public List<FindMaxProjectsClient> findMaxProjectsClients() throws IOException, SQLException{
        List<FindMaxProjectsClient> findMaxProjectsClientList = new ArrayList<>();
//read file with select command
        SQLFileReader sqlFileReader = new SQLFileReader();
        String querry = sqlFileReader.readFile(maxProjectsClientFilePath);
//open connection
        Database database = Database.getInstance();
        Connection conn = database.getConnection();
//create statement
        Statement statement = conn.createStatement();
        //send querry
        ResultSet rs = statement.executeQuery(querry);
        while (rs.next()){
            String name = rs.getString("name");
            int project_count = rs.getInt("project_count");
            findMaxProjectsClientList.add(new FindMaxProjectsClient(name, project_count));
        }
        return findMaxProjectsClientList;
    }

    public List<PrintProjectPrices> printProjectPrices() throws IOException, SQLException{
        List<PrintProjectPrices> printProjectPricesList = new ArrayList<>();
//read file with select command
        SQLFileReader sqlFileReader = new SQLFileReader();
        String querry = sqlFileReader.readFile(printProjectPricesFilePath);
//open connection
        Database database = Database.getInstance();
        Connection conn = database.getConnection();
//create statement
        Statement statement = conn.createStatement();
        //send querry
        ResultSet rs = statement.executeQuery(querry);
        while (rs.next()){
            int name = rs.getInt("name");
            int project_cost = rs.getInt("project_cost");
            printProjectPricesList.add(new PrintProjectPrices(name, project_cost));
        }
        return printProjectPricesList;
    }



}
