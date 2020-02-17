package Servlet;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserRegisterDao;
import Dao.UserRegisterDaoImpl;
import Bean.UserBean;

public class RegisterservletMess extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    request.setCharacterEncoding("utf-8");
		    response.setCharacterEncoding("utf-8");
		    
		    UserBean users = new UserBean();
		    String mess = " ";
		 
		    // 用request对象保存user
			request.setAttribute("user", users);
			String user = request.getParameter("users");
			String password = request.getParameter("password");
			String again_password = request.getParameter("again_password");
  
			if (!password.equals(again_password)) {
				mess = "两次密码不一致，请重新输入";
				users.setMess(mess);
				request.getRequestDispatcher("Registerpage.jsp").forward(request, response);
				return;
			}
			
			// 装到bean对象中
			users.setUsers(user);
			users.setPassword(password);
			
			
			if (user.length() > 0 && password.length() > 0) {
				UserRegisterDao userDao = new UserRegisterDaoImpl();
				boolean flag = userDao.register(users);
				if (flag) {
					mess = "注册成功";
				} else {
					mess = "该用户名已存在，请重新注册 ";
				}
			} else {
				mess = "用户名与密码不能为空 ";
			}
			users.setMess(mess);
			request.getRequestDispatcher("Registerpage.jsp").forward(request, response);
		}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");  // 接收表单的信息
		response.setCharacterEncoding("utf-8");
		doGet(request,response);
		
	}
}
