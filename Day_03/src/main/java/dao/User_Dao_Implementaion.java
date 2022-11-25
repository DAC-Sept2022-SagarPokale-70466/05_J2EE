package dao;

import static DBUtil.DbUtil.getConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.User;

public class User_Dao_Implementaion implements UserDao {

	private Connection con;
	private PreparedStatement pst;
	private PreparedStatement pst2;
	private PreparedStatement pst3;

//	Constructor of DaoImplementation
	public User_Dao_Implementaion() throws SQLException {

		con = getConnection();
		pst = con.prepareStatement("select * from users where email=? and password=?");
		pst2 = con.prepareStatement("update users set status=true where id=?");
		pst3 = con.prepareStatement(
				"insert into users (first_name, last_name, email, password, dob, status, role) values (?, ?, ?, ?, ?, ?, ?);");
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

	@Override
	public String updateVotingStatus(int voterId) throws SQLException {

		pst2.setInt(1, voterId);
		int rowCount = pst2.executeUpdate();
		if (rowCount == 1) {
			return "You have casted a vote successfully!";
		}
		return "Voting Failed";
	}

	public void cleanUp() throws SQLException {
		if (pst != null) {
			pst.close();
			if (pst2 != null)
				pst2.close();
			System.out.println("User Dao Cleaned Up");
		}
	}

	public int insertValues(String fname, String lname, String email, String password, Date date, String role)
			throws SQLException {
		System.out.println("1st Caling");
		pst3.setString(1, fname);
		pst3.setString(2, lname);
		pst3.setString(3, email);
		pst3.setString(4, password);
		pst3.setDate(5, date);
		pst3.setBoolean(6, false);
		pst3.setString(7, role);
		System.out.println("Before Execution Insert statement");
		int rowCount = pst3.executeUpdate();
		System.out.println("After Execution Insert statement");
		if (rowCount == 1) {
			return 1;
		}
		return 0;
	}

}
