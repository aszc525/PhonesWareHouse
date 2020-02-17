<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
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
  
  <% 
  request.setCharacterEncoding("utf-8");

        String Phonenumber=request.getParameter("phonenumber");
	    String Phonename=request.getParameter("phonename");
	    String Screensize=request.getParameter("screensize");
	    String Phonememory=request.getParameter("phonememory");
	    String Price=request.getParameter("price"); 
	    %>
  
    <h2 align="center" ><font color="black">修改手机信息！</font></h2><hr>
  <body Background="image/B.jpg" >
  <form action="ModifyServlet" method="post">
  <table  align="center" border="1" >
  <tr>
      <td>手机编号</td>
      <td><input type="text" name="Phonenumber" value="${param.phonenumber}"></td>
  </tr>
    <tr>
      <td>手机名称</td>
      <td><input type="text" name="Phonename" value="${param.phonename}" ></td>
   </tr>
   <tr>
      <td>屏幕尺寸</td>
      <td><input type="text" name="Screensize" value="${param.screensize}" ></td>
   </tr>
   <tr>
      <td>内存</td>
      <td><input type="text" name="Phonememory" value="${param.phonememory}"></td>
   </tr>
   <tr>
      <td>价格</td>
      <td><input type="text" name="Price" value="${param.price}" ></td>
   </tr>
  <tr>
      <td align="center" colspan="2">
        <input  type="submit" value="提交" />
        <input  type="reset"  value="重置"/>
      </td>
  </tr>
  
  </table>

  </form>
  <div align="center">
  <a href="index.jsp" >返回</a></div>
  
  
  <div class="footer-area">
<hr>
<p align="center">本技术由第一小组提供<br>联系电话：17307426245<br>
<font >@湖南信息学院</font>
</p>
</div>
  </body>
</html>
