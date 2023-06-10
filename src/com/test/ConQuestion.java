package com.test;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.druid.DruidDemo;
import com.utils.JDBCUtils;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;


import java.util.Properties;

public class ConQuestion {
//    public static void main(String[] args) throws Exception {
//        ConQuestion.jdbcTest();
//        ConQuestion.druidTest();
//    }

    @Test
    public void jdbcTest() throws Exception {
        JDBCUtils jdbcUtils = new JDBCUtils();
        long start = System.currentTimeMillis();
        for (int i = 0; i <= 5000; i++) {
            Connection connection = jdbcUtils.getConnection();
            connection.close();
        }
        long stop = System.currentTimeMillis();
        System.out.println((stop - start) + " ms");
    }

    @Test
    public void druidTest() throws Exception {
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
