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
		 
		    // ��request���󱣴�user
			request.setAttribute("user", users);
			String user = request.getParameter("users");
			String password = request.getParameter("password");
			String again_password = request.getParameter("again_password");
  
			if (!password.equals(again_password)) {
				mess = "�������벻һ�£�����������";
				users.setMess(mess);
				request.getRequestDispatcher("Registerpage.jsp").forward(request, response);
				return;
			}
			
			// װ��bean������
			users.setUsers(user);
			users.setPassword(password);
			
			
			if (user.length() > 0 && password.length() > 0) {
				UserRegisterDao userDao = new UserRegisterDaoImpl();
				boolean flag = userDao.register(users);
				if (flag) {
					mess = "ע��ɹ�";
				} else {
					mess = "���û����Ѵ��ڣ�������ע�� ";
				}
			} else {
				mess = "�û��������벻��Ϊ�� ";
			}
			users.setMess(mess);
			request.getRequestDispatcher("Registerpage.jsp").forward(request, response);
		}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");  // ���ձ�����Ϣ
		response.setCharacterEncoding("utf-8");
		doGet(request,response);
		
	}
}
