<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登陆界面</title>
 <style type="text/css">

.outer
   {
	border-style:solid;
	border-color:#CCC;
	width:370px;
	height:230px;
	margin-top:150px;
	margin-left:470px;
	background-image:url(image/5.gif);
	background-repeat:no-repeat;
	background-position:bottom;
	}
.username{
	 margin-top:60px;
	 margin-left:80px;
	     }
.password{
     margin-top:20px;
	 margin-left:80px;
	     }
.input{
	 border-color:#C3F;
	 border-width:1px;
	  }
.button{
     border-radius: 8px;
	 margin-top:20PX;
	 margin-left:150px;
	}
.button1{
     border-radius: 8px;
	 margin-top:20PX;
	 margin-left:40px;
	}
.zhuce{
     margin-top:0PX;
	 margin-left:90%;
     }

</style>
</head> 

<body Background="image/D.jpg">

<form action="LoginServlet" method="post">
<div class="outer" >
<div class="zhuce"><a href="Registerpage.jsp"><font color="violet"><strong>注册</strong></font></a></div>	
        <div class="username">
        	<strong>用户名</strong> <input type="text" name="users" style="background:rgba(0,0,0,0)" style="width:150px"/>
        </div>    
  <div class="password">
   <strong>	密&nbsp;码 </strong><input  type="password" name="password" style="background:rgba(0,0,0,0)" style="width:150px"/>
  </div>
  <div>  
  <input class="button"  type="submit" value="登陆" />
  <input class="button1" type="submit" value="取消"/>
  </div>
</div>
</form>

  </body>

</html>
