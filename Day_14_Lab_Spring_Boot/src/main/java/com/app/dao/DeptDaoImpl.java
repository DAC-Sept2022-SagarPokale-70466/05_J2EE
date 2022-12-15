/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 07-Dec-2022 5:33:58 PM
*/

package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojo.DeptPojo;

@Repository
@Transactional
public class DeptDaoImpl implements DeptDao {

	@Autowired
	private EntityManager manager;

	@Override
	public List<DeptPojo> getAllDepartments() {
		System.out.println("Inside the DeptDaoImpl");
		String jpql = "select d from DeptPojo d";
		return manager.createQuery(jpql, DeptPojo.class).getResultList();
	}

}
