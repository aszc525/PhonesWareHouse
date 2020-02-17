package Dao;
import java.sql.*;
import Dao.UserDao;
import Dao.Conn;
import Bean.UserBean;

public class UserImpl implements UserDao{
	Connection conn=null;
	PreparedStatement prst=null;

	public boolean selectUser(UserBean users) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String mess=" ";
		String sql="select * from Users where users=?";
		ResultSet rs=null;
		Conn database=new Conn();
		try{
			conn=database.getConnection();
			prst=conn.prepareStatement(sql);
			prst.setString(1, users.getUsers());
			rs=prst.executeQuery();
			//�û����Ƿ����
			if(rs.next()){
				String realPass=rs.getString(2);
				if(users.getPassword().equals(realPass.trim())){
					mess="��½�ɹ�";
					flag=true;
				}else{
					//������� 
					mess="�������";
				}
				
			}else{
				//�û���������
				mess="�û���������";
			}
				
		}catch(SQLException e){
			e.printStackTrace();
		}
		users.setMess(mess);
		return flag;
	}

}

