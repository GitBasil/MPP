package prog13_2_soln;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectManager {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/fppdb";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static Connection conn = null;
	public Connection getConnection() throws SQLException {
		if(conn == null) {	
			try {
				conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
				System.out.println("Got connection...");
			}
			catch(SQLException e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
		}
		return conn;
	}
	public void closeConnection(Connection con)  throws SQLException {
		if(con != null && !con.isClosed()) {
			con.close();
		}
	}
}