/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 07-Dec-2022 5:01:38 PM
*/

package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojo.EmpPojo;

@Repository
@Transactional
public class EmpDaoImpl implements EmpDao {

	@Autowired
	private EntityManager manager;

	@Override
	public List<EmpPojo> getEmpsByDeptId(int i) {
		System.out.println("Inside the getEmpbyDeptId method where arg = "+i);
		String jpql = "Select e from EmpPojo e where e.dept.id=:dno";
		return manager.createQuery(jpql, EmpPojo.class).setParameter("dno", i).getResultList();
	}

}
