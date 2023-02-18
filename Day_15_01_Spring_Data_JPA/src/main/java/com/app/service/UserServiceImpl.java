package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.UserDao;
import com.app.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User authenticateUser(String em, String pass) {
		User user = userDao.findByEmailAndPassword(em, pass)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid credentials !! , User not found!!!!"));
		return user;
	}

	@Override
	public void registerUser(User user) {
		userDao.save(user);
	}
}
