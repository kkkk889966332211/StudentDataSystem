package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB2 {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/student_db2?useSSL=false&serverTimezone=UTC";

    public static Connection getCon(){
        String url = DB_URL;
        String username = "root";
        String password = "tiantian";
        String driver_string = JDBC_DRIVER;
        Connection conn = null;
        try {
            Class.forName(driver_string);
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e){
            System.out.println("数据库数据异常");
            e.printStackTrace();
        }
        return conn;
    }
}
