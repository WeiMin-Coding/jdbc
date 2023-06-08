package com.utils;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String src = "src/mysql.properties";
    Connection connection;
    Statement statement;

    public void getConnection() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/mysql.properties"));

            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");

            Class.forName(driver);

            this.connection = DriverManager.getConnection(url, user, password);
            this.statement = this.connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getConnection(String src) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(src));

            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");

            Class.forName(driver);

            this.connection = DriverManager.getConnection(url, user, password);
            this.statement = this.connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ResultSet executeQuery(String sql) throws Exception {
        return this.statement.executeQuery(sql);
    }

    public void close() throws SQLException {
        this.statement.close();
        this.connection.close();
    }
}
