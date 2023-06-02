package com.utils;

import java.sql.*;

public class PostgreSQL_JDBC_Utils {
    String host;
    String database;
    String user;
    String password;
    Connection conn;
    Statement st;

    public PostgreSQL_JDBC_Utils() {
    }

    public PostgreSQL_JDBC_Utils(String host, String database, String user, String password) {
        this.host = host;
        this.database = database;
        this.user = user;
        this.password = password;

        this.connect();
    }

    private void connect() {
        String url = String.format("jdbc:postgresql://%s/%s?user=%s&password=%s&ssl=false", host, database, user, password);

        try {
            this.conn = DriverManager.getConnection(url);
            this.st = this.conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void connect(String host, String database, String user, String password) {
        String url = String.format("jdbc:postgresql://%s/%s?user=%s&password=%s&ssl=false", host, database, user, password);

        try {
            this.conn = DriverManager.getConnection(url);
            this.st = this.conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ResultSet select(String querySql) {
        ResultSet rs = null;
        try {
            rs = st.executeQuery(querySql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }

    public void close() {
        try {
            this.st.close();
            this.conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
