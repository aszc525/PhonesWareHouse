package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Bean.PhoneBean;

public class PhonesDaoImpl implements PhonesDao {
  Connection conn=null;
  PreparedStatement prst=null;
  ResultSet rs=null;
  
	public List<PhoneBean> getAllPhones() {
		List<PhoneBean> list=new ArrayList<PhoneBean>();
		String sql="select * from Phones";
		Conn database=new Conn();
try{
	conn=database.getConnection();
	prst=conn.prepareStatement(sql);
	rs=prst.executeQuery();
	while(rs.next()){
		 PhoneBean phones=new PhoneBean();
		 phones.setPhonenumber(rs.getString(1));
		 phones.setPhonename(rs.getString(2));
		 phones.setScreensize(rs.getString(3));
		 phones.setPhonememory(rs.getString(4));
		 phones.setPrice(rs.getString(5));
		 list.add(phones);
	}
}catch(SQLException e){
	e.printStackTrace();
}
		return list;
	}

}
