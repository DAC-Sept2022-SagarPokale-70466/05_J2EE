/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 08-Dec-2022 4:19:38 PM
*/

package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.User;
import com.app.service.UserService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private UserService userService;

	public CustomerController() {
		System.out.println("Inside the CustomerController");
	}

//	Add request handling method to return list of customers
	@GetMapping
	public List<User> getAllCustomers() {
		System.out.println("in get all customers");
		return userService.getAllCustomers();
	}

}
