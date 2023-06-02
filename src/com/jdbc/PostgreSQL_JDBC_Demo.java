package com.jdbc;

import java.sql.*;
import java.util.Properties;

public class PostgreSQL_JDBC_Demo {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:postgresql://10.8.99.2/zxin";
        Properties props = new Properties();
        props.setProperty("user", "zxdbm_830");

        Connection conn = DriverManager.getConnection(url, props);
        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery("SELECT * FROM s830_user limit 10");
        while (rs.next()) {
            System.out.print("Column 1 returned ");
            System.out.println(rs.getString(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));
            System.out.println(rs.getString(4));
        }

        st.close();
        conn.close();
    }
}
