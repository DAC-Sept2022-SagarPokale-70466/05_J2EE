package com.app.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {
	public HomePageController() {
		System.out.println("in def ctor " + getClass());
	}

	@RequestMapping("/")
	public String showIndexPage(Model map) {
		System.out.println("in show index page " + map);// {}
		map.addAttribute("server_date", new Date());
		return "/index";
	}
}
