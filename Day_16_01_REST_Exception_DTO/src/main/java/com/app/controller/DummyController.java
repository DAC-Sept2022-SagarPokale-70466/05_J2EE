package com.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Mandatory cls level anno that consists of = @Controller , at cls level +
//@ResponseBody : marshalling(serialization) --Java --> JSON , 
//added on ALL req handling methods(@RequestMapping,@GetMapping....)
@RequestMapping("/dummy")
public class DummyController {
	public DummyController() {
		System.out.println("in def ctor of "+getClass());
	}
	//add req handling method (REST API end point) to ret representation of a dummy resource
	@GetMapping
	public List<Integer> getNumberList()
	{
		System.out.println("in get num list");
		return List.of(10,20,30,40,50);//Handler rets the resource anno with @RespBody --> D.S 
		//marshalling Java obj --> Json
	}
}
