<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>AddBooks.jsp</title>
   <style type="text/css">
.footer-area
{
	position:absolute;
	bottom: 0px;
	height: 62px;
	width:100%;
	background:CCCCFFF;
}
</style>
  </head>
  <h2 align="center" ><font color="black">添加手机信息！</font></h2><hr>
  <body Background="image/B.jpg" >
  <form action="AddPhonesServlet" method="post">
  <table   align="center" border="1" >
  <tr>
      <td>手机编号</td>
      <td><input type="text" name="Phonenumber"></td>
  </tr>
    <tr>
      <td>手机名称</td>
      <td><input type="text" name="Phonename"></td>
   </tr>
   <tr>
      <td>屏幕尺寸</td>
      <td><input type="text" name="Screensize"></td>
   </tr>
   <tr>
      <td>内存</td>
      <td><input type="text" name="Phonememory"></td>
   </tr>
   <tr>
      <td>价格</td>
      <td><input type="text" name="Price"></td>
   </tr>
  <tr>
      <td align="center" colspan="2"><input  type="submit" value="提交" />
        <input  type="reset"  value="重置"/>
      </td>
  </tr>
  </table>
  <div align="right">
  <a href="index.jsp" >返回查询</a></div>
  <div align="center">
	<font color="blue">提交反馈：</font>
   ${addPhones.backNews}<%//此处的addPhones是Servlet里面的从表单获取的数据用Bean封装的对象 %>
	</div>
  </form>
  <div class="footer-area">
<hr>
<p align="center">本技术由第一小组提供<br>联系电话：17307426245<br>
<font >@湖南信息学院</font>
</p>
</div>
  </body>
</html>
