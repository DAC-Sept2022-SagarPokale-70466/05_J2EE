package com.app.controller;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.service.VehicleService;
import com.app.pojos.*;
 
@Controller
@RequestMapping("/vehicle")
public class VehicleClass {
	
	@Autowired
	private VehicleService vehicleService;
	
	@GetMapping("/addVehicle")
	String addVehicleToUserList(Model map) {
		System.out.println("Inside the get mapping add vehicle method");
		map.addAttribute("vehicle", new Vehicle());
		return "/vehicle/addVehicle";
	}
	
	@PostMapping("/addVehicle")
	String addVehicleToUserList(@ModelAttribute(name = "vehicle") Vehicle vehicle, HttpSession session) {
		User currentUser = (User) session.getAttribute("user_info");
		vehicle.setUser(currentUser);
		session.setAttribute("user_info", currentUser);
		vehicleService.addVehicle(vehicle);
		return "redirect:/user/details";
	}
	
	@GetMapping("/update/{vid}")
	public String showVehicleDetails(Model model,@PathVariable long vid, HttpSession session) {
		Vehicle vehicle = vehicleService.findVehicle(vid);
		System.out.println(vehicle.getVname());
		model.addAttribute("vehicle_details", vehicle);
		return "/vehicle/update";
	}
	
	@PostMapping("/update/{vid}")
	public String afterUpdateVehicle(@ModelAttribute(name = "vehicle") Vehicle vehicle,@PathVariable long vid, HttpSession session)
	{
		User currentUser = (User) session.getAttribute("user_info");
		vehicle.setUser(currentUser);
		vehicle.setVid(vid);
		vehicleService.updateVehicle(vehicle);
		return "/user/details";
	}
	
	@GetMapping("/delete/{vid}")
	public String deleteVehicle(@PathVariable long vid)
	{
		/*
		Vehicle vehicle = vehicleService.findVehicle(vid);
		System.out.println(vehicle.getVname());
		System.out.println(vid);*/
		vehicleService.deleteVehicle(vid);
		return "redirect:/user/details";
	}
	
	
}
