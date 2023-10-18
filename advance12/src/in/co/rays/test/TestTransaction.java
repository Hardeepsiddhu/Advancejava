package in.co.rays.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestTransaction {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunrays", "root", "root");
		
		try {
			con.setAutoCommit(false);
			Statement stmt = con.createStatement();
			int i = stmt.executeUpdate("insert into emp values(15,'bhuvam',4000)");
			i = stmt.executeUpdate("insert into emp values(15,'shivam',4000)");
			con.commit();
			con.close();
			System.out.println("data inserted "+ i);
		} catch (Exception e) {
			con.rollback();
		}
	}

}
