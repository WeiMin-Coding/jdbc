package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Jdbc02 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://192.168.10.155/db01";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "WeiMin@123");

        Connection connection = DriverManager.getConnection(url, properties);
        System.out.println(connection);
    }
}
