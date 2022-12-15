/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 06-Dec-2022 4:22:33 PM
*/

package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.UserDao;

import pojos.User;

// Mandatory class level annotation to tell SC following is spring bean : Containing B.L
@Service
//Mandatory class level annotation to tell SC -> To auto Suppply transaction management
@Transactional
public class UserServiceImpl implements UserService {

	// Depenency : Dao Layer i/f
	@Autowired
	private UserDao userdao;

	@Override
	public User authenticateUser(String em, String pass) {
		return userdao.validateUser(em, pass);
	}

	@Override
	public String signUpUser(String email, String name, String password) {
		return userdao.signUpUser(email, name, password);

	}

}
