<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
a{text-decoration:none;}
</style>
  </head>
  
<body Background="image/B.jpg">
<h2 align="center"><Strong>欢迎来到手机仓库管理系统！</Strong></h2>
<hr>
<table valign="center" align="center" border="1">
<tr><td>
<a href="QueryServlet"  ><font color="green">查询手机</font></a>
</td>
<td>
<a href="Addpage.jsp"><font color="green">添加手机</font></a>
</td>
</tr>
</table>
<c:choose>
	 	<c:when test="${empty list}">
	 		<center><p>没有信息</p></center>
		 </c:when>
	 <c:otherwise>
	 <center>
    <table border="2" >
	  <tr>
	  	<th width="100">手机编号</th>
	    <th width="100">手机名称</th>
	    <th width="100">屏幕尺寸</th>
	    <th width="100">内存</th>
	     <th width="100">价格</th>
	     <th width="100">操作</th>
	  </tr>
	  <c:forEach var="phones" items="${list}">
	  <tr>
	    <td align="center" valign="center">${phones.phonenumber}</td>
	    <td align="center" valign="center">${phones.phonename}</td>
	    <td align="center" valign="center">${phones.screensize}</td>
	    <td align="center" valign="center">${phones.phonememory}</td>
	    <td align="center" valign="center">${phones.price}</td>    
	    <td>
	    	<form action="DeleteServlet?phonenumber=${phones.phonenumber}" method="post">
		 		 <input type ='hidden' name='delete' value= " ">
                 <input type ='submit'  value='删除' >
		 	</form>
		    <form action="Modifypage.jsp?phonenumber=${phones.phonenumber}&phonename=${phones.phonename}&screensize=${phones.screensize}&phonememory=${phones.phonememory}&price=${phones.price}" method="post">
		 		 <input type ='hidden' name='update' value= " ">
                 <input type ='submit'  value='修改' >
		 	</form>	
		 </td>
	    </tr>
	  </c:forEach>
	  </table>
	</center>
	</c:otherwise>
	</c:choose>
	  
<div class="footer-area">
<hr>
<p align="center">本技术由第一小组提供<br>联系电话：17307426245<br>
<font >@湖南信息学院</font>
</p>
</div>
  </body>
</html>
