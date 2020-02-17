package Dao;

import java.sql.*;

import Bean.PhoneBean;
import Dao.Conn;

public class DeleteDaoImpl implements DeleteDao{

	public boolean Delete(PhoneBean phonenumber) {
		// TODO Auto-generated method stub\
		Connection conn=null;
		PreparedStatement prst=null;
		boolean flag=false;
		Conn data=new Conn();
		String sql="delete  from Phones where Phonenumber=?";
		try{
			conn=data.getConnection();
			prst=conn.prepareStatement(sql);
			prst.setString(1, phonenumber.getPhonenumber());
			int n=prst.executeUpdate();
			if(n>=1)
				flag=true;
		}catch(Exception e){
			e.printStackTrace();
			flag=false;
		}
		return flag;
	}
}
