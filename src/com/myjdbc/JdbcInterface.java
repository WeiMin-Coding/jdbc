package com.myjdbc;

public interface JdbcInterface {
    // 连接数据库
    public Object getConnection();
    // 增删改查
    public void crud();
    // 关闭数据库
    public void close();
}
