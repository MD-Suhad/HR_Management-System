package com.alibou.security.utils;

import java.sql.Connection;
import java.sql.DriverManager;



public class DatabaseConfig {
    private static final String URL = "jdbc:mysql://localhost:3306/suhad";
    private static final String USER = "root";
    private static final String PASSWORD = "??@@suhad@@??";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Updated driver class
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to database successfully.");
        } catch (Exception exception) {
            System.err.println("Database connection failed!");
            exception.printStackTrace();
        }
        return connection;
    }
}
