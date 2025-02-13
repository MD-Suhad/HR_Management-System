package com.alibou.security.utils;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.eclipse.aether.repository.AuthenticationContext.PASSWORD;
import static org.hibernate.cfg.JdbcSettings.URL;
import static org.hibernate.cfg.JdbcSettings.USER;

public class DatabaseConfig {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("connected");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return connection;
    }
}
