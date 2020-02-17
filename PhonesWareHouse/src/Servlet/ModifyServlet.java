package Servlet;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.PhoneBean;
import Dao.ModifyDao;
import Dao.ModifyDaoImpl;

public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置编码方式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//调用Bean层实例一个对象modifyPhones
		PhoneBean modifyPhones=new PhoneBean(); 
		String backNews = " ";
		// 用request对象保存modifyPhones
		request.setAttribute("modifyPhone", modifyPhones);
		//从表单获取对象(name)
	    String Phonenumber=request.getParameter("Phonenumber");
	    String Phonename=request.getParameter("Phonename");
	    String Screensize=request.getParameter("Screensize");
	    String Phonememory=request.getParameter("Phonememory");
	    String Price=request.getParameter("Price");
	    //封装到Bean对象中去
	    modifyPhones.setPhonenumber(Phonenumber);
	    modifyPhones.setPhonename(Phonename);
	    modifyPhones.setScreensize(Screensize);
	    modifyPhones.setPhonememory(Phonememory);
	    modifyPhones.setPrice(Price);
	    modifyPhones.setBackNews(backNews);
	    
	    
	    ModifyDao modifyDao=new ModifyDaoImpl();
	    boolean flag = modifyDao.Modify(modifyPhones);
    	if(flag){
    		request.getRequestDispatcher("QueryServlet").forward(request, response);
    	}else {
    		request.getRequestDispatcher("Modifypage.jsp").forward(request, response);
		}
  	
    }
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置编码方式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		doGet(request,response);
	}

}
