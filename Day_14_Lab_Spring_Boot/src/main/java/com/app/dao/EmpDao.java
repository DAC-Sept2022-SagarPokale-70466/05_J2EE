/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 07-Dec-2022 5:01:54 PM
*/

package com.app.dao;

import java.util.List;

import com.app.pojo.EmpPojo;

public interface EmpDao {

	List<EmpPojo> getEmpsByDeptId(int deptId);
	
}
