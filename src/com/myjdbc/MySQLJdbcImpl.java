package com.myjdbc;

public class MySQLJdbcImpl implements JdbcInterface {
    @Override
    public Object getConnection() {
        System.out.println("得到 MySQL 连接");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("完成 MySQL 增删改查");
    }

    @Override
    public void close() {
        System.out.println("关闭 MySQL 连接");
    }
}
