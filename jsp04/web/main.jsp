<%--
  Created by IntelliJ IDEA.
  User: yangyixin
  Date: 2021/4/7
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <center>
       <h1>欢迎来到商城主页</h1>
       <h2>快快来选购吧</h2>
       <%
           session.setAttribute("uid",1);//模拟1号用户登录
       %>
       <div>
           名称:羽绒服00<br>
           价格:68<br>
           库存:700<br>
           <a href="CarsAdd?gid=1">加入购物车</a>
       </div>
       <div>
           名称:牛仔裤<br>
           价格:38<br>
           库存:100<br>
           <a href="CarsAdd?gid=2">加入购物车</a>
       </div>
       <div>
           名称:保暖裤<br>
           价格:58.99<br>
           库存:100<br>
           <a href="CarsAdd?gid=3">加入购物车</a>
       </div>
   </center>
</body>
</html>
