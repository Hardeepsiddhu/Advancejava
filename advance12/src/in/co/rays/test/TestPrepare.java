package in.co.rays.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestPrepare {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunrays", "root","root");
		PreparedStatement ps = con.prepareCall("insert into emp values(?,?,?)");
		ps.setInt(1, 10);
		ps.setString(2, "dinesh");
		ps.setInt(3, 5600);
		int i = ps.executeUpdate();
		System.out.println("data inserted"+i);
	}

	
}
