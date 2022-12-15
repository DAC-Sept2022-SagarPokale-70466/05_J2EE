/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 09-Dec-2022 10:16:23 PM
*/

package com.app.service;

import java.util.List;

import com.app.pojo.Emp;

public interface EmpService {

	List<Emp> getAllEmp();

	Emp addEmployee(Emp emp);

	Emp findEmpById(Integer id);

	String removeEmp(Integer id);
	
}
