package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.UserDao;
import com.app.dto.UserDto;
import com.app.pojos.Role;
import com.app.pojos.ShoppingCart;
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
		User user = userDao.findByEmailAndPassword(em, pass)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid credentials !! , User not found!!!!"));
		// user : PERSISTENT
		return user;
	}// tx over -- success --commit --auto dirty chking --session.flush() --> no DMLs
		// --> session.close
		// L1 cache destroyed , cn rets to CP , user : DETACHED

	@Override
	public List<User> getAllCustomers() {
		// TODO Auto-generated method stub
		return userDao.findByUserRole(Role.CUSTOMER);
	}

	@Override
	public User getDetails(long custId) {
		// TODO Auto-generated method stub
		return userDao.findById(custId).orElseThrow(() -> new ResourceNotFoundException("Customer id invalid !!!!"));
	}

	@Override
	public UserDto registerUser(User customer) {
		// create empty cart
		ShoppingCart cart = new ShoppingCart();
		customer.addCart(cart);
		User user = userDao.save(customer);
		// copy the props User entity --> User DTO
		UserDto dto = new UserDto(user.getFirstName(), user.getLastName(), user.getEmail(), user.getUserRole());
		return dto;
	}
            
	@Override
	public UserDto updateUserDetails(long userId, User user) {
		// validate user id
		User existingUser = userDao.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid user id : updation failed!!!"));
		// simply invoke save => saveOrUpdate
		//get existing cart
		user.setCart(existingUser.getCart());
		User persistentUser = userDao.save(user);
		return new UserDto(persistentUser.getFirstName(), persistentUser.getLastName(), persistentUser.getEmail(),
				persistentUser.getUserRole());
	}

	@Override
	public String deleteUserDetails(long userId) {
		// validate user id
		User existingUser = userDao.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid user id : deletion failed!!!"));
	//=> user exist
		userDao.deleteById(userId);
		return "User info deleted successfully!";
	}
	
	

}
