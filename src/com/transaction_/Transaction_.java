package com.transaction_;

import com.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class Transaction_ {
    @Test
    public void noTransaction() throws SQLException {
        JDBCUtils jdbcUtils = new JDBCUtils();
        jdbcUtils.connection();

        String sql1 = "update account set balance = balance - 100 where id = 1";
        String sql2 = "update account set balance = balance + 100 where id = 2";

        try {
            int res1 = jdbcUtils.executeUpdate(sql1);

            int i = 1 / 0;

            int res2 = jdbcUtils.executeUpdate(sql2);
            System.out.println(res1 + " " + res2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.close();
        }

    }

    @Test
    public void transaction() {
        JDBCUtils jdbcUtils = new JDBCUtils();
        Connection connection = jdbcUtils.getConnection();

        try {
            connection.setAutoCommit(false);

            String sql1 = "update account set balance = balance - 100 where id = 1";
            String sql2 = "update account set balance = balance + 100 where id = 2";
            int res1 = jdbcUtils.executeUpdate(sql1);

//            int i = 1 / 0;

            int res2 = jdbcUtils.executeUpdate(sql2);
            connection.commit();
            System.out.println(res1 + " " + res2);
        } catch (Exception e) {
            try {
                connection.rollback();
                e.printStackTrace();
            } catch (Exception a) {
                a.printStackTrace();
            }
        } finally {
            jdbcUtils.close();
        }
    }
}
