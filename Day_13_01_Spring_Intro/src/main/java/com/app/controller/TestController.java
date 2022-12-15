package com.app.controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test") // Optional BUT reco : cls level anno used for separation
public class TestController {
	public TestController() {
		System.out.println("in ctor of " + getClass());
	}

	// add req handling method to test model map
	@GetMapping("/test2") // =@RequestMapping(method=GET) :
	// doGet --can only intercept Http GET requests
	public String testModelMap(Model map) {

		System.out.println("in test model map " + map);// {}
		map.addAttribute("server_ts", new Date()).
		addAttribute("number_list", List.of(10, 20, 30, 40));
		System.out.println("Map after "+map);//populated map : 2 attrs
		return "/basic/display";//Handler rets explicitly LVN + SC implicitly model map -->D.S
		//D.S ---> LVN ---> V.R ---> AVN : /WEB-INF/views/basic/display.jsp -->D.S
		//chks for model attrs --> adds them under req scope --> forwards the clnt --> JSP
	}
}
