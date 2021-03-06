package RESTfulExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn {
	
	
	protected static Connection getConnection() throws Exception {
		
		String myUrl = "jdbc:mysql://localhost:3306/testdb";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(myUrl, "root", "abcd1234");
		
		return conn;
	}
	
	protected static void closeResources(ResultSet rs, Statement stmt,Connection conn) {
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				
			}
		}
		
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				
			}
			}
		
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				
			}
		}
	}
}
