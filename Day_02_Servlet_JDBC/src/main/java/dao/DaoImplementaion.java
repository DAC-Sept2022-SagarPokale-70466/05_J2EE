package dao;

import static DBUtil.DbUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.User;

public class DaoImplementaion implements UserDao {

	private Connection con;
	private PreparedStatement pst;

//	Constructor of DaoImplementation
	public DaoImplementaion() throws SQLException {

		con = getConnection();
		pst = con.prepareStatement("select * from users where email=? and password=?");
		System.out.println("User Dao Created");

	}

	@Override
	public User authenticateUser(String email, String pwd) throws SQLException {

//		Setting the parameter in prepared statement
		pst.setString(1, email);
		pst.setString(2, pwd);

		try (ResultSet rs = pst.executeQuery()) {
			/*
			 * userId, String firstName, String lastName, String email, String password,
			 * Date dob, boolean votingStatus, String role
			 */
			if (rs.next()) {
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3), email, pwd, rs.getDate(6),
						rs.getBoolean(7), rs.getString(8));
			}
		}
		return null;
	}

	public void cleanUp() throws SQLException {
		if (pst != null) {
			pst.close();
			System.out.println("User Dao Cleaned Up");
		}
	}

}
