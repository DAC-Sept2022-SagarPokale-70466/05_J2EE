package com.app.controller;

import java.time.LocalDateTime;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // MANDATRY cls level anno to tell SC following is a spring bean for request
			// handling
//singleton n eager
public class HelloController {
	public HelloController() {
		System.out.println("in ctor of " + getClass());
	}

	@PostConstruct
	public void init() {
		System.out.println("in init of " + getClass());
	}

	// add req handling method : to test MVC flow (render "Hello World!")
	@RequestMapping("/hello") // MANDATORY method level anno to tell SC ,
	// following is the req handling method , which can intercept ANY request (get |
	// post| put|delete ...)
	// => service of Servlets !
	// Map created by SC : : key :/hello , value :
	// com.app.controller.HelloController : sayHello
	public String sayHello() {
		System.out.println("in say hello");
		return "/welcome";// Handler rets Logical View Name ---> D.S
	}

	// add req handling method : to generate dyn resp
	@RequestMapping("/test1")
	public ModelAndView testModelAndView() {
		System.out.println("in test m n v");
		// To share the results of B.L with the view layer , add them in model attr/s
		// o.s.w.s.ModelAndView => holder of logical view name + model attr/s
		// ModelAndView(String logicalViewName,String modelAttrName,Object modelAtrVal)
		return new ModelAndView("/welcome", "server_ts", LocalDateTime.now());
		//Handler sends MnV --> D.S --> LVN --> V.R --> AVN --> D.S --> chks for model attrs 
		//---> Yes --> stores them under curnt req scope(req.setAttr) -->-forwards the clnt --> view
		// --> ${requestScope.attrName}
	}

}
