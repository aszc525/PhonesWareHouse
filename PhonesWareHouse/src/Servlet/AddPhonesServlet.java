package Servlet;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.PhoneBean;
import Dao.AddPhonesDao;
import Dao.AddPhonesDaoImpl;

public class AddPhonesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	    //调用Bean层声明一个方法
	    PhoneBean addPhones=new PhoneBean();
	    String backNews = " ";
	    
	   // 用request对象保存addBooks
	    request.setAttribute("addPhones",addPhones);
	   //从表单获取对象
	    String Phonenumber=request.getParameter("Phonenumber");
	    String Phonename=request.getParameter("Phonename");
	    String Screensize=request.getParameter("Screensize");
	    String Phonememory=request.getParameter("Phonememory");
	    String Price=request.getParameter("Price");
	    //封装到Bean对象中去
	    addPhones.setPhonenumber(Phonenumber);
	    addPhones.setPhonename(Phonename);
	    addPhones.setScreensize(Screensize);
	    addPhones.setPhonememory(Phonememory);
	    addPhones.setPrice(Price);
	    addPhones.setBackNews(backNews);
	    
	    //调用Dao层，DaoImpl类
	    if(Phonenumber.length()>0 && Phonename.length()>0 && Screensize.length()>0 
	    		&& Phonememory.length()>0 && Price.length()>0){
	    	AddPhonesDao addPhonesDao=new AddPhonesDaoImpl();
	    	boolean flag = addPhonesDao.AddPhones(addPhones);
	    	if(flag){
	    		backNews = "添加成功";
	    	}else {
				backNews = "手机编号已存在请重新添加";
			}
	    	addPhones.setBackNews(backNews);  //封装到Bean对象中去，反馈信息
	    	//如果为空则照样还在添加页面
	    	request.getRequestDispatcher("Addpage.jsp").forward(request, response);
	    }
	    
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	    doGet(request,response);
	}

}
