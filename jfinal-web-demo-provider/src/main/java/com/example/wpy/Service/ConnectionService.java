package com.example.wpy.Service;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionService {
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/androidserver",
                    "root", "22003x");
            return connection;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
