package in.co.rasy.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import in.co.rays.util.JdbcDataSource;

public class TestProcedureIn {

	public static void main(String[] args)  throws Exception{
		Connection con = JdbcDataSource.getConnection();
		
		CallableStatement callstmt = con.prepareCall("{CALL emp1IN(?)}");
		callstmt.setInt(1, 2);
		callstmt.execute();
		ResultSet rs = callstmt.getResultSet();
		
		while(rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getInt(3));
		}
	}
}
