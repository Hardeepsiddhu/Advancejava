package in.co.rays.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JdbcDataSource {
	ResourceBundle  rb = ResourceBundle.getBundle("in.co.rays.bundle.system");

	private static JdbcDataSource jds = null;
	
	private ComboPooledDataSource cpds = null;
	
	
	private JdbcDataSource() {
		try {
			cpds = new ComboPooledDataSource();
			cpds.setDriverClass(rb.getString("driver"));
			cpds.setJdbcUrl(rb.getString("url"));
			cpds.setUser(rb.getString("username"));
			cpds.setPassword(rb.getString("password"));
			cpds.setInitialPoolSize(Integer.parseInt(rb.getString("initialpoolsize")));
			cpds.setAcquireIncrement(Integer.parseInt(rb.getString("acquireIncrement")));
			cpds.setMaxPoolSize(Integer.parseInt(rb.getString("maxpoolsize")));
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
