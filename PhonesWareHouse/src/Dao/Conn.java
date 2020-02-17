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
			System.out.println("驱动加载成功");
		} catch (Exception e) {
			System.out.println("驱动加载失败");
			e.printStackTrace();
			
		}
		try {
			con = DriverManager.getConnection(url, "sa", "123456");
			System.out.println("成功连接数据库！");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("连接数据库失败！");
		} 
		return con;
	}
}
