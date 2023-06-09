package com.utils;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String src = "src/mysql.properties";
    Connection connection;
    Statement statement;
    PreparedStatement preparedStatement;

    public void connection() {
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

    public Connection getConnection() {
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

        return this.connection;
    }

    public void connection(String src) {
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
        this.preparedStatement = connection.prepareStatement(sql);
        return preparedStatement.executeQuery();
    }

    public int executeUpdate(String sql) throws Exception {
        this.preparedStatement = connection.prepareStatement(sql);
        return this.preparedStatement.executeUpdate();
    }

    public void close() throws SQLException {
        this.statement.close();
        this.preparedStatement.close();
        this.connection.close();
    }
}
