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
		//1�����ձ��ύ����������
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String users=request.getParameter("users");//����һ���ַ�����users�ӱ���ȡusers
		String password=request.getParameter("password");
	    // 2��������װ�ص�javabean��
		UserBean user=new UserBean();
		user.setUsers(users);//�Ѵӱ���ȡ��users�÷������ʵ������userװ�ص�������
		user.setPassword(password);
		// 3) �������ݲ�Dao
		UserDao userdao=new UserImpl();
		boolean flag=userdao.selectUser(user);
		HttpSession session=request.getSession();
		session.setAttribute("user", user);//���浽�Ự��
		//4��ת������ͬ��ҳ��(index.jsp,error.jsp)��ͬʱӦ�� session����     bean��Ϣ
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
