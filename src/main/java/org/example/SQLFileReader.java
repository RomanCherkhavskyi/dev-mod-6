package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SQLFileReader {

    public String readFile(String filePath) throws IOException {
        //create buffer reader for read file
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
//create StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        String line;
//read file
        while ((line = reader.readLine()) != null){
            stringBuilder.append(line);
            stringBuilder.append("\n");
        }
        reader.close();

        return stringBuilder.toString();
    }
}
