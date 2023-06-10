package com.jdbc;

import java.io.FileInputStream;
import java.sql.*;
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

        String sql1 = "insert into news values(5, '新闻标题', '新闻内容')";
        String sql2 = "update news set content='嘻嘻笑' where id = 1";
        String sql3 = "delete from news where id = 3";
        String sql4 = "select id,name,sex,borndate from actor";

        ResultSet resultSet = statement.executeQuery(sql4);
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String sex = resultSet.getString("sex");
            Date date = resultSet.getDate("borndate");
            System.out.println(id + "\t" + name + "\t" + sex + "\t" + date);
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
