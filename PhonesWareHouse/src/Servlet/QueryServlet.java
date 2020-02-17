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
	   //新建操作对象
	   PhonesService phonesService=new PhonesServiceImpl();
	   //调用查询方法
	   List<PhoneBean> list=phonesService.getAllPhones();
	   //把数组存入会话中
	   
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
