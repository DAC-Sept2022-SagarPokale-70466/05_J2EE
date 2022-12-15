/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 07-Dec-2022 3:19:22 PM
*/

package com.app.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.DeptDao;
import com.app.dao.EmpDao;
import com.app.pojo.EmpPojo;

@Controller
public class HomePageController {

	@Autowired
	private DeptDao deptdao;
	@Autowired
	private EmpDao empdao;
	
	public HomePageController() {
		System.out.println("IN the constructor of " + getClass());
	}
// add req handling method to render home page

	@GetMapping("/")
	public String showHomePage(Model map) {
		map.addAttribute("server_date", new Date());
		System.out.println("In Show Home Page Method" + map);
		map.addAttribute("server_date", new Date());
		map.addAttribute("dept_list", deptdao.getAllDepartments());	
		return "/home"; // Handler to D.S -> A.V.N :: WEB-INF/views/dept.jsp
	}

//	@GetMapping("/dept")
//	public String showDept(Model map) {
//		System.out.println("In Show Home Page Method" + map);
//		map.addAttribute("server_date", new Date());
//		map.addAttribute("dept_list", deptdao.getAllDepartments());
//
//		return "/dept"; // Handler to D.S -> A.V.N :: WEB-INF/views/dept.jsp
//	}
	
	
	@RequestMapping("/dept/emp")
	public String showemp(@RequestParam int deptid, Model map) {
		System.out.println("Inside the Dept/emp method where dept = "+deptid);
		for (EmpPojo iterable_element : empdao.getEmpsByDeptId(deptid)) {
			System.out.println(iterable_element);
		}
		map.addAttribute("empList", empdao.getEmpsByDeptId(deptid));
		return "/empList";
	}
}
