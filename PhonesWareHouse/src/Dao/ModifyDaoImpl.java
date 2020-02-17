package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Bean.PhoneBean;

public class ModifyDaoImpl implements ModifyDao {
	boolean flag=false;
	String backNews=" ";
	public boolean Modify(PhoneBean modifyphone) {
		
		Connection conn=null;
		PreparedStatement prst=null;
		String sql="UPDATE Phones SET Phonename=?,Screensize=?,Phonememory=?,Price=?  where Phonenumber=?";
		Conn data=new Conn();
		
	try{
	    conn=data.getConnection();
	    prst=conn.prepareStatement(sql);
		prst.setString(1, modifyphone.getPhonename());
		prst.setString(2, modifyphone.getScreensize());
		prst.setString(3, modifyphone.getPhonememory());
		prst.setString(4, modifyphone.getPrice());
		prst.setString(5, modifyphone.getPhonenumber());
		System.out.println(modifyphone.getPhonename());
		int n=prst.executeUpdate();
		if(n>=1){
	    flag=true;
	    }else{
	    	flag=false;
	    	backNews="ÐÞ¸ÄÊ§°Ü";
	    }
		}catch(Exception e){
		e.printStackTrace();
		}
	return false;
	}
}
