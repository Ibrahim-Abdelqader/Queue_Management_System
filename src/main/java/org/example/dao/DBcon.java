package org.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBcon {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 3306;
    private static final String DB_NAME = "metro";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection conn;

    public static Connection getConnection(){
        try{
            conn = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s",HOST,PORT,DB_NAME),USER,PASSWORD);
            System.out.println("✅ Database connected successfully!");
        }catch(SQLException e){
            System.out.println("❌ Connection failed!");
            e.printStackTrace();
        }
        return conn;
    }

}
