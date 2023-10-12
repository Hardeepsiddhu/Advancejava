package in.co.rays.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestCrud {
public static void main(String[] args) throws Exception{
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunrays","root", "root");
	
	PreparedStatement ps = con.prepareStatement("insert into emp values(9,'jignesh',2500)");
	int i = ps.executeUpdate();
	System.out.println("data inserted" + i);
}
}
