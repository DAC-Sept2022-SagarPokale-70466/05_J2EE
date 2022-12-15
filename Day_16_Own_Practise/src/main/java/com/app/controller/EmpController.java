/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 09-Dec-2022 10:40:18 PM
*/

package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojo.Emp;
import com.app.service.EmpService;

@RestController
@RequestMapping("/employee")
public class EmpController {

	@Autowired
	private EmpService empService;

	public EmpController() {
		System.out.println("Inside the Controller");
	}

	@GetMapping()
	public List<Emp> getAllEmployee() {
		return empService.getAllEmp();
	}
	
	@GetMapping("/{id}")
	public Emp findEmpById(@PathVariable Integer id) {
		return empService.findEmpById(id);
	}

	@PostMapping
	public Emp allEmployee(@RequestBody Emp emp) {
		System.out.println("Adding New Employee Inside the Controller");
		return empService.addEmployee(emp);
	}
	
	@DeleteMapping
	public String deleteEmp(@PathVariable Integer id) {
		System.out.println("Inside the Delete Method");
		
		
		return empService.removeEmp(id);
	}
}
