package com.test;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.druid.DruidDemo;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;


import java.util.Properties;

public class ConQuestion {
    public static void main(String[] args) throws Exception {
        ConQuestion.jdbcTest();
        ConQuestion.druidTest();
    }

    public static void jdbcTest() throws Exception {
        String url = "jdbc:postgresql://10.8.99.2/zxin";
        Properties props = new Properties();
        props.setProperty("user", "zxdbm_830");

        long start = System.currentTimeMillis();
        for (int i = 0; i <= 5000; i++) {
            Connection conn = DriverManager.getConnection(url, props);
            conn.close();
        }
        long stop = System.currentTimeMillis();
        System.out.println((stop - start) + " ms");
    }

    public static void druidTest() throws Exception {
        Properties properties = new Properties();
        InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("Druid.properties");
        properties.load(is);
        DataSource ds = DruidDataSourceFactory.createDataSource(properties);

        long start = System.currentTimeMillis();
        for (int i = 0; i <= 5000; i++) {
            Connection con = ds.getConnection();
            con.close();
        }
        long stop = System.currentTimeMillis();
        System.out.println((stop - start) + " ms");
    }
}
