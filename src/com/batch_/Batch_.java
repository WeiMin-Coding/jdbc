package com.batch_;

import com.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Batch_ {
    @Test
    public void testInsertBigDataNoBatch() {
        JDBCUtils jdbcUtils = new JDBCUtils();
        Connection connection = jdbcUtils.getConnection();

        long startTime = System.currentTimeMillis();
        for (int i = 0; i <= 5000; i++) {
            String sql = String.format("insert into account values (null, 'UserName%s', %s);", i, i);

            try {
                connection.setAutoCommit(false);
                jdbcUtils.executeUpdate(sql);
                connection.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        long stopTime = System.currentTimeMillis();

        jdbcUtils.close();

        System.out.println("Time: " + (stopTime - startTime) + " ms");
    }

    @Test
    public void testInsertBigDataBatch() throws Exception {
        JDBCUtils jdbcUtils = new JDBCUtils();
        Connection connection = jdbcUtils.getConnection();

        String sql = "insert into account values (null, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1, String.format("WeiMin%s", i));
            preparedStatement.setString(2, String.format("%s", (i + 10000)));

            preparedStatement.addBatch();
            if (i % 1000 == 0) {
                preparedStatement.executeBatch();
                preparedStatement.clearParameters();
            }
        }
        long stopTime = System.currentTimeMillis();

        jdbcUtils.close();

        System.out.println("Time: " + (stopTime - startTime) + " ms");
    }
}
