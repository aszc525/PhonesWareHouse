package Servlet;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.PhoneBean;
import Service.PhonesService;
import Service.PhonesServiceImpl;

public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
   try{
	   //�½���������
	   PhonesService phonesService=new PhonesServiceImpl();
	   //���ò�ѯ����
	   List<PhoneBean> list=phonesService.getAllPhones();
	   //���������Ự��
	   
	   request.setAttribute("list", list);
	   request.getRequestDispatcher("index.jsp").forward(request, response);
   }catch(Exception e){
	   e.printStackTrace();
   }
}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		doGet(request,response);
	}
}
