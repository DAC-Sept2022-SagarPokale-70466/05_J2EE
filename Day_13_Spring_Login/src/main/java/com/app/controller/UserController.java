/**

*	@Developer : Sagar_Pokale
*	@Date		 	   : 06-Dec-2022 3:27:12 PM
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

import pojos.User;

@Controller
@RequestMapping("/user") // Optional but recommended for separating user related actions
public class UserController {
	// Dependency : Service Layer i/f
	@Autowired
	private UserService userService;

	public UserController() {
		System.out.println("In the Constructor of " + getClass());
	}

//	Add request handling method to show login form page
	@GetMapping("/login")
	public String showLoginForm() {
		System.out.println("In the show login Form method");
		return "/user/login";
//		AVN :: WEB-INF/views/user/login.jsp
	}

//	add req handling mathod to process login form
//	@RequestParam	:: Method agrument to supply the binding (mapping) between request parameter --> Method argument
//	String myEmail = request.getParameter("myEmail")
//	(@RequestParam(name = "myPassword") String pass)
//	String myPassword = request.getParameter("myPassword")
//	For Simplification -> Match request param names -> Method argument names

	@PostMapping("/login")
	public String processLoginForm(@RequestParam String myEmail, @RequestParam String myPassword, Model map) {
		System.out.println("In process login Form ");
// Call service layer method for user validation
		try {
			User user = userService.authenticateUser(myEmail, myPassword);
			map.addAttribute("msg", "Login Successfull");
			map.addAttribute("user_details", user);
		} catch (RuntimeException e) {
			System.out.println("Error in Process Login Form " + e);
			map.addAttribute("error", "Invalide Login -> Please Retry : ) ");
			return "/user/login"; // AVN :: WEB-INF/views/user/login.jsp
		}
		return "/user/details";

//		AVN :: WEB-INF/views/user/details.jsp
	}

}
