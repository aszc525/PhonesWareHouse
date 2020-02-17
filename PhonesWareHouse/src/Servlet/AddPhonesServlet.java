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
	    //����Bean������һ������
	    PhoneBean addPhones=new PhoneBean();
	    String backNews = " ";
	    
	   // ��request���󱣴�addBooks
	    request.setAttribute("addPhones",addPhones);
	   //�ӱ���ȡ����
	    String Phonenumber=request.getParameter("Phonenumber");
	    String Phonename=request.getParameter("Phonename");
	    String Screensize=request.getParameter("Screensize");
	    String Phonememory=request.getParameter("Phonememory");
	    String Price=request.getParameter("Price");
	    //��װ��Bean������ȥ
	    addPhones.setPhonenumber(Phonenumber);
	    addPhones.setPhonename(Phonename);
	    addPhones.setScreensize(Screensize);
	    addPhones.setPhonememory(Phonememory);
	    addPhones.setPrice(Price);
	    addPhones.setBackNews(backNews);
	    
	    //����Dao�㣬DaoImpl��
	    if(Phonenumber.length()>0 && Phonename.length()>0 && Screensize.length()>0 
	    		&& Phonememory.length()>0 && Price.length()>0){
	    	AddPhonesDao addPhonesDao=new AddPhonesDaoImpl();
	    	boolean flag = addPhonesDao.AddPhones(addPhones);
	    	if(flag){
	    		backNews = "��ӳɹ�";
	    	}else {
				backNews = "�ֻ�����Ѵ������������";
			}
	    	addPhones.setBackNews(backNews);  //��װ��Bean������ȥ��������Ϣ
	    	//���Ϊ���������������ҳ��
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
