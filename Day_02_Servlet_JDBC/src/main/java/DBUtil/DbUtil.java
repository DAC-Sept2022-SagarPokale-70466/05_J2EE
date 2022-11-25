package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	private static Connection con;

	public static void openConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/advjava";
		con = DriverManager.getConnection(url, "root", "Sagar@154");
		System.out.println("Get Established");
	}

	public static Connection getConnection() {
		return con;
	}

	public static void closeConnection() throws SQLException {
		if (con != null) {
			con.close();
			System.out.println("Connection Closed");
		}

	}
}
