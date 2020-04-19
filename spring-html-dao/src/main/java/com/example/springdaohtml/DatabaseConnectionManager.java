package com.example.springdaohtml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionManager {

    private String url;
    private String user;
    private String password;
    private  static DatabaseConnectionManager instance;


    private DatabaseConnectionManager() {
    }

    public static DatabaseConnectionManager getInstance(){
        if(instance == null){
            instance = new DatabaseConnectionManager();
        }
        return instance;
    }


    public Connection getConnection() throws SQLException {


        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/application.properties");
            properties.load(fileInputStream);
            this.url = properties.getProperty("db.url");
            this.user = properties.getProperty("db.user");
            this.password = properties.getProperty("db.password");



        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return DriverManager.getConnection(url, user, password);
    }
}
