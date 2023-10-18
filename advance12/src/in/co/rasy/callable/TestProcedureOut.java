package in.co.rasy.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

import in.co.rays.util.JdbcDataSource;

public class TestProcedureOut {

	public static void main(String[] args) throws Exception {

		Connection con = JdbcDataSource.getConnection();

		CallableStatement callStmt = con.prepareCall("{CALL empOut(?)}");
		callStmt.registerOutParameter(1, Types.INTEGER);
		callStmt.execute();
		System.out.println(callStmt.getInt(1));
	
	}

}
