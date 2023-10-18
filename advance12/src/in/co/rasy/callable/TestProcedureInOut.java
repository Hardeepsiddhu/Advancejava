package in.co.rasy.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import in.co.rays.util.JdbcDataSource;

public class TestProcedureInOut {

	public static void main(String[] args) throws Exception {


		Connection con = JdbcDataSource.getConnection();
		CallableStatement callstmt = con.prepareCall("{CALL emp1INOUT(?)}");
		callstmt.setInt(1, 1);
		callstmt.registerOutParameter(1, Types.INTEGER);
		callstmt.execute();
		System.out.println(callstmt.getInt(1));
	}
}
