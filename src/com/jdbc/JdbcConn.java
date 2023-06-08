package com.jdbc;

import com.mysql.cj.jdbc.Driver;
import com.sun.javafx.binding.StringFormatter;
import org.junit.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class JdbcConn {
    @Test
    public void connect01() throws Exception {
        Driver driver = new Driver();

        String url = "jdbc:mysql://192.168.10.155/db01";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "WeiMin@123");

        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }

    @Test
    public void connect02() throws Exception {
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        String url = "jdbc:mysql://192.168.10.155/db01";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "WeiMin@123");

        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }

    @Test
    public void connect03() throws Exception {
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        String url = "jdbc:mysql://192.168.10.155/db01";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "WeiMin@123");

        DriverManager.registerDriver(driver);
        Connection connection = DriverManager.getConnection(url, properties);
        System.out.println(connection);
    }

    @Test
    public void connect04() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://192.168.10.155/db01";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "WeiMin@123");

        Connection connection = DriverManager.getConnection(url, properties);
        System.out.println(connection);
    }

    @Test
    public void connect05() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/mysql.properties"));

        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    @Test
    public void test01() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/mysql.properties"));

        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();

        for (int i = 0; i <= 5; i++) {
            String sql = String.format("insert into news values (%s, 'Title%s', 'Content%s')", i, i, i);
            int res = statement.executeUpdate(sql);
            if (res > 0) {
                System.out.println(sql + " OK");
            }
        }
    }
}
