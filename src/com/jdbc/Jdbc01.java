package com.jdbc;


import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;

public class Jdbc01 {
    public static void main(String[] args) throws Exception {
        // 1. 注册驱动
        Driver driver = new Driver();

        // 2. 得到连接
        String url = "jdbc:mysql://192.168.10.155/db01";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "WeiMin@123");
        Connection connect = driver.connect(url, properties);

        // 3. 执行sql
        String sql1 = "insert into actor values(null, 'WeiMin', 'M', '1996-09-01', '88888888')";
        String sql2 = "update actor set name = 'WM' where id = 1";
        String sql3 = "delete from actor where id = 1";
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql3);
        System.out.println("Rows: " + rows);

    }
}
