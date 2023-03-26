package org.example;

import java.io.IOException;
import java.sql.SQLException;

public class DatabasePopulateService {

    private static final String populate_dbPath = "sql\\populate_db.sql";
    public static void main(String[] args) throws IOException, SQLException {
        SQLFileReader sqlFileReader = new SQLFileReader();
        String sql = sqlFileReader.readFile(populate_dbPath);

        Database.sendSQLExecuteUpdate(sql);
    }
}
