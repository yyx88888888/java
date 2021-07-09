package com.sc.dao;

import com.sc.bean.Goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDao {
    Connection connection=null;
    PreparedStatement preparedStatement=null;
    ResultSet resultSet=null;

    public Goods select(int gid) throws SQLException, ClassNotFoundException {
        Goods goods = null;
        connection = DBConn.getConn();
        String sql = "select * from goods where gid=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, gid);
        resultSet = preparedStatement.executeQuery();
        while (resultSet != null && resultSet.next()) {

            goods = new Goods(resultSet.getInt("gid"),
                    resultSet.getString("gname"),
                    resultSet.getFloat("gprice"),
                    resultSet.getString("gimg"),
                    resultSet.getInt("gnum"),
                    resultSet.getInt("gstock"));

        }
        //关闭资源
        DBConn.close(connection, preparedStatement, this.resultSet);
        return goods;
    }


    //查询所有商品
    public List<Goods> selectAll() throws SQLException, ClassNotFoundException {
        List<Goods> list = new ArrayList<>();
        connection = DBConn.getConn();
        String sql = "select * from goods ";
        preparedStatement = connection.prepareStatement(sql);

        resultSet = preparedStatement.executeQuery();
        while (resultSet != null && resultSet.next()) {
            Goods goods = new Goods(resultSet.getInt("gid"),
                    resultSet.getString("gname"),
                    resultSet.getFloat("gprice"),
                    resultSet.getString("gimg"),
                    resultSet.getInt("gnum"),
                    resultSet.getInt("gstock"));
            list.add(goods);

        }
        //关闭资源
        DBConn.close(connection, preparedStatement, this.resultSet);
        return list;
    }

    //查询商品
    public void add(Goods goods) throws SQLException, ClassNotFoundException {

        connection = DBConn.getConn();
        String sql = "insert into goods vales(null,?,?,?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, goods.getGname());
        preparedStatement.setFloat(2, goods.getGprice());
        preparedStatement.setString(3, goods.getGimg());
        preparedStatement.setInt(4, goods.getGnum());
        preparedStatement.setInt(5, goods.getGstock());
        preparedStatement.executeUpdate();
        DBConn.close(connection, preparedStatement, resultSet);

    }

    //修改商品
    public void update(Goods goods) throws SQLException, ClassNotFoundException {

        connection = DBConn.getConn();
        String sql = "update goods set gname=?,gprice=?,gimg=?,gnum=?,gstock=? where gid=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, goods.getGname());
        preparedStatement.setFloat(2, goods.getGprice());
        preparedStatement.setString(3, goods.getGimg());
        preparedStatement.setInt(4, goods.getGnum());
        preparedStatement.setInt(5, goods.getGstock());
        preparedStatement.setInt(6, goods.getGid());
        preparedStatement.executeUpdate();
        DBConn.close(connection, preparedStatement, resultSet);

    }

    //删除商品
    public void delete(int gid) throws SQLException, ClassNotFoundException {

        connection = DBConn.getConn();
        String sql = "delete from goods where gid=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, gid);
        preparedStatement.executeUpdate();
        DBConn.close(connection, preparedStatement, resultSet);

    }
}

