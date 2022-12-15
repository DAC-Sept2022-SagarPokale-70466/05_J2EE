package com.app.service;

import java.util.List;

import com.app.dto.UserDto;
import com.app.pojos.User;

public interface UserService {
//add B.L method for user validation
	User authenticateUser(String em,String pass);
	//add B.L method to get all customers
	List<User> getAllCustomers();
	User getDetails(long custId);
	UserDto registerUser(User customer);
	UserDto updateUserDetails(long userId, User user);
	String deleteUserDetails(long userId);
}
