<%@ page import="java.util.List" %>
<%@ page import="com.sc.bean.Cars" %><%--
  Created by IntelliJ IDEA.
  User: yangyixin
  Date: 2021/4/7
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
   <h1>我的购物车</h1>
   <h2>
       <a href="main.jsp">继续购物</a>
   </h2>
  <%
      List<Cars> list= (List<Cars>) session.getAttribute("list");
      for (int i = 0; i <list.size() ; i++) {

          Cars cars=list.get(i);
          out.print(cars.getGid()+"-");
          out.print(cars.getGname()+"-");
          out.print(cars.getGprice()+"-");
          out.print(cars.getGnum()+"-");
          out.print(cars.getUid()+"<br>");

      }
  %>
</center>
</body>
</html>
