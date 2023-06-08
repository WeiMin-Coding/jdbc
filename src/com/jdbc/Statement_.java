package com.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Statement_ {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Admin: ");
        String admin = scanner.nextLine();
        System.out.print("Password: ");
        String pass = scanner.nextLine();

        Properties properties = new Properties();
        properties.load(new FileInputStream("src/mysql.properties"));

        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();

        String sql = String.format("select name,pwd " +
                "from admin " +
                "where name='%s' " +
                "and pwd='%s';", admin, pass);
        System.out.println(sql);
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            System.out.println("登录成功！");
        } else {
            System.out.println("登录失败");
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
