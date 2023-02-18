package com.app.controller;

import java.util.concurrent.ExecutionException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.User;
import com.app.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	public UserController() {
		System.out.println("Inside user Controller");

	}

	@GetMapping("/register")
	public String ShowForm(Model map) {
		map.addAttribute("user", new User());
		return "/user/register";
	}

	@PostMapping("/register")
	public String saveUser(@ModelAttribute User user, RedirectAttributes flashmap) {
		userService.registerUser(user);
		return "/user/login";
	}

	@GetMapping("/login")
	public String showLogInForm() {
		return "/user/login";
	}

	@PostMapping("/login")
		public String processLoginForm(@RequestParam String email, @RequestParam String password, Model map, HttpSession session) {
			System.out.println("in process login form " + email + " " + password);
			try {
				User user = userService.authenticateUser(email, password);
				System.out.println(user.getEmail());
				if (user != null) {
					map.addAttribute("user_details", user);
					session.setAttribute("user_info", user);
					return "/user/details";
				}
			} catch (RuntimeException e) {
				System.out.println("err in process login form " + e);
				map.addAttribute("mesg", "Invalid Login, pls retry!!!");
				return "/user/login";
			}
			return "/user/details";
		}
	
	@GetMapping("/logout")
	public String logoutUser(HttpSession session, Model map, HttpServletRequest request, HttpServletResponse resp) {
		map.addAttribute("details", session.getAttribute("user_details"));
		session.invalidate();
		resp.setHeader("refresh", "5;url=" + request.getContextPath());
		return "/user/logout";
	}
	
	@GetMapping("/details")
	public String showDetails(HttpSession session,Model map) {
		User currentUser = (User) session.getAttribute("user_info");
		com.app.pojos.Vehicle v = (com.app.pojos.Vehicle) session.getAttribute("vehicle_details");
		map.addAttribute(v);
		session.setAttribute("user_info", currentUser);
		return "/user/details";
	}
}
