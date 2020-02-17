package Servlet;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDao;
import Dao.UserImpl;
import Bean.UserBean;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1）接收表单提交过来的数据
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String users=request.getParameter("users");//定义一个字符串类users从表单获取users
		String password=request.getParameter("password");
	    // 2）把数据装载到javabean类
		UserBean user=new UserBean();
		user.setUsers(users);//把从表单获取的users用方法层的实例化类user装载到方法层
		user.setPassword(password);
		// 3) 调用数据层Dao
		UserDao userdao=new UserImpl();
		boolean flag=userdao.selectUser(user);
		HttpSession session=request.getSession();
		session.setAttribute("user", user);//保存到会话中
		//4）转发到不同的页面(index.jsp,error.jsp)，同时应用 session保存     bean信息
		if(flag){
			response.sendRedirect("index.jsp");
		}else{
			response.sendRedirect("error.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
