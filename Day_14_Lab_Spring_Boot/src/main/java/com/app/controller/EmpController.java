/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 07-Dec-2022 5:11:38 PM
*/

package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.EmpDao;

@Controller
public class EmpController {

	@Autowired
	private EmpDao empdao;

	public EmpController() {
		System.out.println("inside the Empcontroller");
	}

	@RequestMapping("/emplist")
	public String showEmpList(@RequestParam Integer deptid, Model map) {
		System.out.println("Inside the method show Emp list");
		map.addAttribute("empList", empdao.getEmpsByDeptId(deptid));
		return "/empList";
	}

}
