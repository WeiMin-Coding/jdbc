package com.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DruidDemo {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("Druid.properties");

        properties.load(is);
        DataSource ds = DruidDataSourceFactory.createDataSource(properties);
        Connection con = ds.getConnection();

        String sql = "SELECT * FROM actor limit 10";

        //获取执行sql的对象
        Statement statement = con.createStatement();
        //执行sql
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.print(resultSet.getString(1));
            System.out.print(resultSet.getString(2));
            System.out.print(resultSet.getString(3));
            System.out.print(resultSet.getString(4));
            System.out.println();
        }

        statement.close();
        con.close();
    }
}
