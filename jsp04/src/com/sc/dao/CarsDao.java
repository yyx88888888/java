package com.sc.dao;

import com.sc.bean.Cars;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

public class CarsDao {

    Connection connection=null;
    PreparedStatement preparedStatement=null;
    ResultSet resultSet=null;



    public void add(Cars cars) throws SQLException, ClassNotFoundException {
       //获取数据库连接
        connection=DBConn.getConn();

        String sql="insert into cars values(null,?,?,?,?,?,?)";
        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,cars.getGid());
        preparedStatement.setString(2,cars.getGname());
        preparedStatement.setFloat(3,cars.getGprice());
        preparedStatement.setString(4,cars.getGimg());
        preparedStatement.setInt(5,cars.getGnum());
        preparedStatement.setInt(6,cars.getUid());
        //调用
        preparedStatement.executeUpdate();
        //关闭资源
        DBConn.close(connection,preparedStatement,resultSet);

    }

    public List<Cars> selectById(int uid) throws SQLException, ClassNotFoundException {
        connection=DBConn.getConn();
        List<Cars> list=new ArrayList<>();

        String sql="select * from cars where uid=?";
        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,uid);
        resultSet=preparedStatement.executeQuery();
        while (resultSet!=null&&resultSet.next()){
            Cars cars=new Cars(resultSet.getInt("cid"),
                              resultSet.getInt("gid"),
                              resultSet.getString("gname"),
                              resultSet.getFloat("gprice"),
                              resultSet.getString("gimg"),
                              resultSet.getInt("gnum"),
                              resultSet.getInt("uid"));

            list.add(cars);

        }
        //关闭资源
        DBConn.close(connection,preparedStatement, this.resultSet);
        return list;
    }



}



