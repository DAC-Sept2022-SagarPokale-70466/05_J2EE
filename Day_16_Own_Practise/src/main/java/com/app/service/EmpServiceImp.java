/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 09-Dec-2022 10:15:01 PM
*/

package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.EmpDao;
import com.app.pojo.Emp;

@Service
@Transactional
public class EmpServiceImp implements EmpService {

	@Autowired
	private EmpDao empdao;

	@Override
	public List<Emp> getAllEmp() {
		return empdao.findAll();
	}

	@Override
	public Emp addEmployee(Emp emp) {
		System.out.println("Adding Emp Inside the Service Method");
		return empdao.save(emp);
	}

	@Override
	public Emp findEmpById(Integer id) {
		return empdao.findById(id).orElseGet(() -> new Emp());
	}

	@Override
	public String removeEmp(Integer id) {

		Emp existing = empdao.findById(id).orElse(new Emp());

		return "Deleted Succesffully";
	}

}
