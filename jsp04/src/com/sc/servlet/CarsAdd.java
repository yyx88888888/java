package com.sc.servlet;

import com.sc.bean.Cars;
import com.sc.bean.Goods;
import com.sc.dao.CarsDao;
import com.sc.dao.GoodsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/CarsAdd")
public class CarsAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //获取gid参数值
        String gidStr=req.getParameter("gid");
        int gid=Integer.parseInt(gidStr);

        //通过gid查询整个商品对象
        GoodsDao goodsDao=new GoodsDao();


        try {
            Goods goods = goodsDao.select(gid);

            //从session中获取用户uid
            HttpSession session = req.getSession();
            int uid = (int)session.getAttribute("uid");

            //封装cars对象
            Cars cars=new Cars(0,goods.getGid(),
                    goods.getGname(),goods.getGprice(),
                    goods.getGimg(),goods.getGnum(),
                    uid);
            //调用dao添加cars
            CarsDao carsDao = new CarsDao();
            carsDao.add(cars);

            //通过用户编号uid查询该用户的购物车商品
            List<Cars> list = carsDao.selectById(uid);

            //把商品集合存入session
            session.setAttribute("list",list);
            //重定向到购物车页面
            resp.sendRedirect("cars.jsp");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}

