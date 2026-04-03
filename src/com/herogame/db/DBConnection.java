package com.herogame.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/herogame";
        String user = "root";
        String password = "root";

        return DriverManager.getConnection(url, user, password);
    }
}