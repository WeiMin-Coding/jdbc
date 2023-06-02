package com.test;

import com.myjdbc.MySQLJdbcImpl;

public class TestMyJDBC {
    public static void main(String[] args) {
        MySQLJdbcImpl mySQLJdbc = new MySQLJdbcImpl();
        mySQLJdbc.getConnection();
        mySQLJdbc.crud();
        mySQLJdbc.close();
    }
}
