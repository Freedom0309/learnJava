package com.freedom.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author: Allen Liu
 * @Description:
 * @Date: Created in 15:22 2018/2/23
 * @Modified By:
 **/
public class DBUtils {

    //需要访问的数据库的地址
    private static final String URL = "jdbc:mysql://127.0.0.1/jcohy?characterEncoding=utf-8&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    private static Connection conn = null;

    static {
        try {
            //加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获得数据库连接
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return conn;
    }

}

