package com.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class ResultSet_ {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/mysql.properties"));

        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from news");
        while (resultSet.next()) {
//            int id = resultSet.getInt(1);
            int id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            String content = resultSet.getString("content");
            System.out.printf("%s, %s, %s\n", id, title, content);
        }
    }
}
