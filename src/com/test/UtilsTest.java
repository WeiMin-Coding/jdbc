package com.test;

import com.utils.JDBCUtils;
import com.utils.PostgreSQL_JDBC_Utils;
import org.junit.Test;

import java.sql.ResultSet;

public class UtilsTest {
    @Test
    public void test01() throws Exception {
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

    @Test
    public void testJDBCUtils01() throws Exception {
        JDBCUtils jdbcUtils = new JDBCUtils();
        jdbcUtils.getConnection();

        ResultSet resultSet = jdbcUtils.executeQuery("select * from news");
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String title = resultSet.getString("title");
            String content = resultSet.getString("content");
            System.out.printf("%s, %s, %s\n", id, title, content);
        }

        jdbcUtils.close();
    }
}
