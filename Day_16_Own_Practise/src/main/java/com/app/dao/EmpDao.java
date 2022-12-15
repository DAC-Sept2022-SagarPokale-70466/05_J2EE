/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 09-Dec-2022 10:09:36 PM
*/

package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Emp;

public interface EmpDao extends JpaRepository<Emp, Integer> {

//	List<Emp> findAllEmps();


//	Optional<Emp> getAll
	
}
