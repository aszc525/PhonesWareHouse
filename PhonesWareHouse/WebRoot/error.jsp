<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>


 </head>
  
<body Background="image/B.jpg">
  <div align="center">
  <img src="image/3.png">
  <div align="center">
   ${user.mess}           
  <a href="denglu.jsp">返回</a>
  </div>
  </div>
  </body>

</html>
