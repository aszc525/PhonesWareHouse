<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">



<html>
  <head>
    <title>Registerpage.jsp</title>
  </head>
  <h2 align="center"><font color="black">欢迎注册用户！</font></h2>
  <body Background="image/B.jpg" >
  <form action="RegisterservletMess" method="post">
  <table   align="center" border="1" >
  
  <tr>
      <td>用户名</td>
      <td><input type="text" name="users"></td>
  </tr>
    <tr>
      <td>密码&nbsp;&nbsp;&nbsp;&nbsp;</td>
      <td><input type="password" name="password"></td>
   </tr>
   <tr>
      <td>确认密码&nbsp;&nbsp;&nbsp;&nbsp;</td>
      <td><input type="password" name="again_password"></td>
   </tr>
  <tr>
      <td align="center" colspan="2"><input  type="submit" value="注册" />
        <input  type="reset"  value="重置"/>
      </td>
  </tr>
  </table>

  <div align="center">
	<font color="blue">注册反馈：</font>
	${user.mess}
	</div>
	<div align="center">
  <a href="denglu.jsp" >返回</a></div>
  </form>
  </body>
</html>
