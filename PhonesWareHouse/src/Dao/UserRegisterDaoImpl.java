package Dao;

import java.sql.*;
import Dao.UserRegisterDao;
import Bean.UserBean;
public class UserRegisterDaoImpl implements UserRegisterDao {
	Connection conn=null;
	PreparedStatement prst=null;
	String sql="insert into Users values(?,?)";
	public boolean register(UserBean users) {
		// TODO Auto-generated method stub
		boolean flag=false;
		Conn data=new Conn();
		
		try{
			conn=data.getConnection();
			prst=conn.prepareStatement(sql);
			prst.setString(1,users.getUsers());
			prst.setString(2,users.getPassword());
			int n=prst.executeUpdate();
			if(n>0)
				flag=true;
		}catch (SQLException e){
			e.printStackTrace();
			return flag;
		}
		return flag;
		 
	}
}
