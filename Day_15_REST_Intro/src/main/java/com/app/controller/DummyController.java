/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 08-Dec-2022 3:52:17 PM
*/

package com.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Mandatory class level annotation that consists of = @Controller, at class
				// level + @ResponseBody : Marshalling(Serialization) -- JAVA -> JSON
//Added on all request handling method (@RequestMapping, @GetMapping)
@RequestMapping("/dummy")
public class DummyController {

	public DummyController() {
		System.out.println("Inside the DummyController" + getClass());
	}

//	Add the request handling method (REST API end point) to return representation of a dummy resource 
	@GetMapping
	public List<Integer> getNumberedList() {
		System.out.println("In the get num list");
		return List.of(10, 20, 30, 40, 50); // Handler returns Resource annotated with @ResponceBody -> D.S
//		Marshalling JAVA obj ---> JSON
	}

}
