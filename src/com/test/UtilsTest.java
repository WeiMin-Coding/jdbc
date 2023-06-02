package com.test;

import com.utils.PostgreSQL_JDBC_Utils;

import java.sql.ResultSet;

public class UtilsTest {
    public static void main(String[] args) throws Exception {
        PostgreSQL_JDBC_Utils postgreSQL = new PostgreSQL_JDBC_Utils();
        postgreSQL.connect("10.8.99.2", "zxin", "zxdbm_830", "");
        ResultSet rs = postgreSQL.select("SELECT * FROM s830_user limit 10");

        while (rs.next()) {
            System.out.print("Column 1 returned ");
            System.out.print(rs.getString(1));
            System.out.print(rs.getString(2));
            System.out.print(rs.getString(3));
            System.out.print(rs.getString(4));
            System.out.println();
        }

        postgreSQL.close();
    }
}
