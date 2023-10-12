package in.co.rays.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestAdd {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunrays","root", "root");
		
		
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("insert into emp1 values(3,'hardeep',1500)");
		i = stmt.executeUpdate("insert into emp1 values(2,'shubham',2000)");
	
		
		System.out.println("data inserted" +i);
	}

}
