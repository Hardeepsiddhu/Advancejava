package in.co.rays.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestMethod {
	public static void main(String[] args) throws Exception {
		
		//testselect();
		add(8,"sleep",5000);
		
	}

	private static void add(int id ,String name,int salary) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunrays", "root", "root");
		Statement smt = conn.createStatement();
		
		int i = smt.executeUpdate("insert into emp values("+ id +",'"+ name +"',"+ salary +")");
		System.out.println("data inserted"+ i);
	}

	private static void testselect() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunrays", "root", "root");
		Statement smt = con.createStatement();
		
		ResultSet rs = smt.executeQuery("select * from emp");
		
		while(rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t"+rs.getString(2));
			System.out.println("\t"+rs.getInt(3));
		}
	}

}
