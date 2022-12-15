/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 06-Dec-2022 11:34:02 PM
*/

package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.service.UserService;

@Controller
@RequestMapping("/user")
public class UserSignup {

	@Autowired
	private UserService userService;
	private Model addAttribute;

	public UserSignup() {
		System.out.println("inside the usersingup");
	}

	@GetMapping("/signup")
	public String showSignUpForm() {
		System.out.println("Showing SignUp Form");
		return "/user/signup";
	}

	@PostMapping("/signup")
	public String signUpUser(@RequestParam String email, @RequestParam String name, @RequestParam String password, Model mm) {
		try {
			mm.addAttribute("nn", name);
			userService.signUpUser(email, name, password);
			return "/user/success";
		} catch (RuntimeException e) {
			System.out.println("Error Inside Controller");
		}
		return "/user/singup";
	}
}
