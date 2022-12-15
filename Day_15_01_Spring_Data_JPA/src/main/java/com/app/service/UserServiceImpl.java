package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.UserDao;
import com.app.pojos.User;

@Service // mandatory cls level anno to tell SC following is spring bean , containing B.L
@Transactional // mandatory cls level anno to tell SC --to auto supply tx management
public class UserServiceImpl implements UserService {
	// dependency : DAO layer i/f
	@Autowired
	private UserDao userDao;

//Tx begins
	@Override
	public User authenticateUser(String em, String pass) {
		// currently no B.L
//		Optional holding a user
		User user = userDao.findByEmailAndPassword(em, pass)
				.orElseThrow(() -> 
				new ResourceNotFoundException("Invalid credentials !! , User not found!!!!"));
//		user : Persistent
		return user;
	}// tx over -- success --commit --auto dirty chking --session.flush() --> no DMLs
		// --> session.close
		// L1 cache destroyed , cn rets to CP

}
