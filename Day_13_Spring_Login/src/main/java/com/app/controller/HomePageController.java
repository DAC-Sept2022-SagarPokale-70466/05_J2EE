/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 06-Dec-2022 2:43:53 PM
*/

package com.app.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//Mandatory class level annotataion to  tell SC --following is req handling controller = Handler
//Scope -> Singlton and eager : Spring bean
@Controller
public class HomePageController {

	public HomePageController() {
		System.out.println("Inside the consturctor of " + getClass());
	}

//	add req handling method to forward the client to the index page 
//	Output on client browser : Welcome to spring MVC at server time stamp
	@RequestMapping("/")
	public String showIndexPage(Model map) { // Dependency Model Map
		System.out.println("In Show index page " + map); // {}
//		Model addAttribute(String nn, Object val)
		map.addAttribute("server_date", new Date());
		return "/index"; // "/" is Important
//		Handler returns  Explicitly Logical View Name(LVN) +Implicitly Model map D.S -> LVN -> V.R
//		AVN : prefix + LVN + postfix
//		/ WEB-INF/views/index.jsp -> D.S -> add model attribute under request scope
// 		-> Forward to view layer
	}
}
