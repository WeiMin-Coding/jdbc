package com.jdbc;

import com.mysql.cj.jdbc.Driver;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
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
}
