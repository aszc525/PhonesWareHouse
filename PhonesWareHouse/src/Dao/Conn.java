package Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
	public Connection getConnection() throws SQLException {
		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=WareHouse";
		Connection con = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("�������سɹ�");
		} catch (Exception e) {
			System.out.println("��������ʧ��");
			e.printStackTrace();
			
		}
		try {
			con = DriverManager.getConnection(url, "sa", "123456");
			System.out.println("�ɹ��������ݿ⣡");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�������ݿ�ʧ�ܣ�");
		} 
		return con;
	}
}
