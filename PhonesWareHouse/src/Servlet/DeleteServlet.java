package Servlet;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.PhoneBean;
import Dao.DeleteDao;
import Dao.DeleteDaoImpl;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String phonenumber=request.getParameter("phonenumber");
		
		PhoneBean delete=new PhoneBean();
		delete.setPhonenumber(phonenumber);
		
	try{
		DeleteDao deleteDao=new DeleteDaoImpl();
		boolean flag=deleteDao.Delete(delete);
		if(flag){
			request.getRequestDispatcher("QueryServlet").forward(request, response);
		}else{
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}catch(Exception e){
		e.printStackTrace();
	 }
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           doGet(request,response);
           request.setCharacterEncoding("utf-8");
   		   response.setCharacterEncoding("utf-8");
   		
	}

}
