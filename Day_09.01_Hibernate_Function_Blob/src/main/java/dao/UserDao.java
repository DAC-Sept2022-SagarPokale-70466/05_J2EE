package dao;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import pojos.Role;
import pojos.User;

public interface UserDao {
	String registerUser(User details);

	String registerUserWithGetCurntSession(User details);

//add a method to ret user details by it's id
	User getUserDetailsById(int userId);

//add a method to get all users' details
	List<User> getAllUserDetails();

//add a method to get selected  users' details
	List<User> getUsersByDateAndRole(LocalDate beginDate, LocalDate endDate, Role role);

	// add a method to get selected users' details by role
	List<String> getUserNamesByRole(Role role);
	//add a method to get projection(selected props) for users by date n role : testing ctor expresssion
	List<User> getUsersByDateAndRole2(LocalDate beginDate,Role role);
	//add a method to change user's pwd
	String changePassword(String email,String oldPwd,String newPwd);
	//add a method to bulk update the details
	String applyDiscountBulkUpdate(LocalDate endDate,double discount);
	//add a method to delete user details
	String deleteUserDetails(int userId);
	//add a method to store image in db
	String storeImage(int userId,String fileName) throws IOException;
	//add a method to restore image from  db--> new file
	String restoreImage(int userId, String fileName) throws IOException;

}
