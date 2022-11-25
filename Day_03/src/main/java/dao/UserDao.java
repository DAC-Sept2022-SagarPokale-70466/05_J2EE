package dao;

import java.sql.SQLException;

import pojo.User;

public interface UserDao {
	
	User authenticateUser(String email,String pwd) throws SQLException;
	//add a method to change the voting status of the voter
	String updateVotingStatus(int voterId) throws SQLException;
}
