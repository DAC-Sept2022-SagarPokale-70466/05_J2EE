package com.app.service;

import com.app.pojos.User;

public interface UserService {
	User authenticateUser(String email, String password);

	void registerUser(User user);}
