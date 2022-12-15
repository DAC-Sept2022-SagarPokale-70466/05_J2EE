package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Role;
import com.app.pojos.User;
import com.app.service.UserService;

@Controller
@RequestMapping("/user") // Optional BUT reco for separating user related actions
public class UserController {
	// dependency : servie layer i/f
	@Autowired
	private UserService userService;

	public UserController() {
		System.out.println("in def ctor of " + getClass());
	}

	// add req handling method to show login form
	@GetMapping("/login")
	public String showLoginForm() {
		System.out.println("in show login form");
		return "/user/login";// AVN : /WEB-INF/views/user/login.jsp
	}

	// add req handling method to process login form
	// @RequestParam : method arg anno to supply the binding between req param -->
	// method arg
	// String email = request.getParameter("email");
	// @RequestParam(name = "password") String pass
	// String pass=request.getParameter("password");
	// For simplification : Match req param names --> method arg names !
	@PostMapping("/login")
	public String processLoginForm(@RequestParam String email, @RequestParam String password, Model map,
			HttpSession session, RedirectAttributes flashMap) {
		System.out.println("in process login form " + email + " " + password);
		// call service layer method for user validation
		try {
			User user = userService.authenticateUser(email, password);
			// valid login
			flashMap.addFlashAttribute("mesg", "Login Successful");// mesg scope : till the NEXT request
			session.setAttribute("user_details", user);// user details : till user invalidates session
			// => valid login --> role based authorization
			if (user.getUserRole() == Role.ADMIN) {
				return "redirect:/admin/main";
			}
			// SC : resp.sendRedirect(resp.encodeRedirectURL("admin/main")) --skips V.R ,
			// View layer
			// ---> temp resp sent to clnt : SC 302 , location : admin/main , set-cookie:
			// JSESSIONId , body : empty
			// clnt will auto send next req : http://host:port/day14/admin/main , method=GET
			// => user : customer role
			return "redirect:/customer/categories";
//			Redirect only with header 
		} catch (RuntimeException e) {
			System.out.println("err in process login form " + e);
			// => invalid login -- add the err mesg
			map.addAttribute("mesg", "Invalid Login , Pls retry!!!!!!!!!!!!!!");
			return "/user/login";// AVN : /WEB-INF/views/user/login.jsp
		}

	}

	// http://host:port/day15_boot/user/logout
	// add a req handling method to logout the curnt user
	@GetMapping("/logout")
	public String logoutUser(HttpSession session, Model map, HttpServletRequest request, HttpServletResponse resp) {
		System.out.println("in logout");
		// JSP : hello user name
//		Getting the user detaila from session scope n storing it under the requst scope(model atts)
		map.addAttribute("details", session.getAttribute("user_details"));
		// invalidate session
		session.invalidate();
		// logout mesg : JSP
		// set resp header : refresh
		resp.setHeader("refresh", "5;url=" + request.getContextPath());
// Because the responce buffer is goining to discard
		return "/user/logout";// AVN --> /WEB-INF/views/user/logout.jsp
	}
}
