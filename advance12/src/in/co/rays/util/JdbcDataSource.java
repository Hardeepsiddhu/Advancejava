package in.co.rays.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JdbcDataSource {

	private static JdbcDataSource jds = null;
	
	private ComboPooledDataSource cpds = null;
	
	private JdbcDataSource() {
		try {
			cpds = new ComboPooledDataSource();
			cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
			cpds.setJdbcUrl("jdbc:mysql://localhost:3306/sunrays");
			cpds.setUser("root");
			cpds.setPassword("root");
			cpds.setInitialPoolSize(5);
			cpds.setAcquireIncrement(5);
			cpds.setMaxPoolSize(50);
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
}
	public static JdbcDataSource getInstance() {
	if (jds == null) {
		jds = new JdbcDataSource();
	}
	return jds;
}
	public static Connection getConnection() {
		try {
			return getInstance().cpds.getConnection();
		} catch (SQLException e) {
			return null;
		}
		
}
	public static void closeConnection(Connection conn,Statement stmt, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void closeConnection(Connection conn, Statement stmt) {
		closeConnection(conn, stmt, null);
	}
	public static void closeConnection(Connection conn) {
		closeConnection(conn, null, null);
	}
}
