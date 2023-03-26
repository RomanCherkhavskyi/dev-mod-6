package org.example;


public class DatabaseInitService {

    private static final String init_dbPath = "sql\\init_db.sql";
    public static void main(String[] args)  throws Exception{

        SQLFileReader sqlFileReader = new SQLFileReader();
        String sql = sqlFileReader.readFile(init_dbPath);

        Database.sendSQLExecute(sql);


    }
}
