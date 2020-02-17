package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Bean.PhoneBean;



public class AddPhonesDaoImpl implements AddPhonesDao {
	 Connection conn=null;
	 PreparedStatement prst=null;
	 String sql="insert into Phones values(?,?,?,?,?)";
	public boolean AddPhones(PhoneBean AddPhones) {
		// TODO Auto-generated method stub
		boolean flag=false;
		Conn data=new Conn();
		try{
			conn=data.getConnection();
			prst=conn.prepareStatement(sql);
			prst.setString(1, AddPhones.getPhonenumber());
			prst.setString(2, AddPhones.getPhonename());
			prst.setString(3, AddPhones.getScreensize());
			prst.setString(4, AddPhones.getPhonememory());
			prst.setString(5, AddPhones.getPrice());
			int n=prst.executeUpdate();
		 if(n>0)
			 flag=true;
		 
		}catch(Exception e){
			e.printStackTrace();
			return flag;
		}
		return flag;
	}
}

