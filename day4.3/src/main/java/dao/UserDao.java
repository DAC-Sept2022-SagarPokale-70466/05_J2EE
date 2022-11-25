package dao;

import java.sql.SQLException;

import pojos.User;

public interface UserDao {
//add a method to validate user
	User authenticateUser(String email,String pwd) throws SQLException;
	//add a method to change the voting status of the voter
	String updateVotingStatus(int voterId) throws SQLException;
}
