package com.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDto;
import com.app.pojos.User;
import com.app.service.UserService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	// dep : service layer i/f
	@Autowired
	private UserService userService;

	public CustomerController() {
		System.out.println("in def ctor " + getClass());
	}

	// add req handling method to return list of customers
	@GetMapping
	public List<UserDto> getAllCustomers() {
		System.out.println("in get all custs");
		List<User> customers = userService.getAllCustomers();
		return customers.stream()
				.map(c -> new UserDto(c.getId(), c.getFirstName(), c.getLastName(), c.getEmail(), c.getUserRole()))
				.collect(Collectors.toList());

	}

	// add REST API end point to get details of a specific customer
	@GetMapping("/{custId}")
	// HOw to tell SC to inject a path / URI var in to method arg ? @PathVariable
	// ResponseEntity(T body,HttpStatys sts)
	public ResponseEntity<?> getCustomerDetails(@PathVariable long custId) {
		System.out.println("in get cust details " + custId);
		// try {
		return new ResponseEntity<>(userService.getDetails(custId), HttpStatus.OK);
//		} catch (RuntimeException e) {
//			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//		}
	}

	// REST API call to register a new customer
	@PostMapping
	public UserDto addCustomerDetails(@RequestBody @Valid User customer)// for un marshalling (de ser) json --> java
	{

		System.out.println("in add cust dtls " + customer);
		return userService.registerUser(customer);

	}

	// REST API call to update customer details
	@PutMapping("/{userId}")
	public UserDto updateUserDetails(@PathVariable long userId, @RequestBody User user) {
		System.out.println("in update user " + userId + " user : " + user);
		return userService.updateUserDetails(userId, user);
	}

	// REST API call to delete customer details
	@DeleteMapping("/{userId}")
	public String deleteUserDetails(@PathVariable long userId) {
		System.out.println("in del user details " + userId);
		return userService.deleteUserDetails(userId);
	}

}
