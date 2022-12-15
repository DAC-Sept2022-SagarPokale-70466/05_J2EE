/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 06-Dec-2022 4:10:44 PM
*/

package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pojos.User;
import pojos.*;

// Mandatory annotation to tell SC : Following is a spring bean : DAO layer
// Singlton n Eager
@Repository
public class UserDaoImpl implements UserDao {
	// Dependency : SessionFactory
	@Autowired // autowire = byType
//	No Hiberanate Utils / No Ctx listener
	private SessionFactory sf;

	private User user;
	@Override
	public User validateUser(String email, String pass) {
		String jpql = "select u from User u where u.email = :em and u.password=:pass";
		return sf.getCurrentSession().createQuery(jpql, User.class).setParameter("em", email).setParameter("pass", pass).getSingleResult();
	}
	
	public String signUpUser(String email, String name, String password) {
		
		String msg = "Retry";
		user = new User(name, name, email, password, null);
		try {
		sf.getCurrentSession().save(user);
		msg = "SignUp Successfull";
		}
		catch(RuntimeException e) {
			System.out.println("Error in Query "+e);
		}
		return msg;
	}
}
