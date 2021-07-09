package com.sc.dao;

import com.mysql.jdbc.Driver;

import java.sql.*;

public class DBConn {
    public static String DRIVERNAME="com.mysql.jdbc.Driver";
    public static String URL="jdbc:mysql://localhost:3306/db2002";
    public static String USERNAME="root";
    public static String PASSWORD="root";

    //获取数据库连接的方法
    public static Connection getConn() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVERNAME);
        System.out.println("加载数据库驱动成功！");
        Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD);
        System.out.println("连接数据库成功！");
        return connection;
    }

    public static void close(Connection connection,
                             PreparedStatement preparedStatement,
                             ResultSet resultSet) throws SQLException {
        if(resultSet!=null){
            resultSet.close();
        }
        if(preparedStatement!=null){
            preparedStatement.close();
        }
        if(connection!=null){
            connection.close();
        }
    }

}
