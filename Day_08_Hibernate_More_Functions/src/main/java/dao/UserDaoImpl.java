package dao;

import pojos.Role;
import pojos.User;
import org.hibernate.*;
import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.List;

public class UserDaoImpl implements UserDao {

	@Override
	public String registerUser(User details) {
		// details : TRANSIENT => not yet part of L1 cache, does not have db
		// identity(i.e no corresponding rec in db , exists ONLY in java obj heap
		// get session from Session Factory
		Session hibSession = getFactory().openSession();
		Session hibSession2 = getFactory().openSession();
		System.out.println(hibSession == hibSession2);// false
		// begin a transaction
		Transaction tx = hibSession.beginTransaction();
		System.out.println("is open " + hibSession.isOpen() + " is connected " + hibSession.isConnected());// t t

		try {
			hibSession.save(details);
			// details : PERSISTENT : part of L1 cache , not yet in db
			// => success !
			tx.commit();// Upon commit , hibernate perform auto dirty checking --session.flush --> since
						// new entity is a part of L1 cache n doesn't have rec in db -- insert query
			System.out.println(
					"after commit : is open " + hibSession.isOpen() + " is connected " + hibSession.isConnected());// t
																													// t

		} catch (RuntimeException e) {
			// => error -- rollback tx
			if (tx != null)
				tx.rollback();
			// re throw the exception to the caller
			throw e;
		} finally {
			// close the session
			if (hibSession != null)
				hibSession.close();// pooled out db cn rets to the pool n L1 cache is destroyed
		}
		System.out.println(
				"after finally  : is open " + hibSession.isOpen() + " is connected " + hibSession.isConnected());// f f

		// details : DETACHED
		return "User registered with ID =" + details.getUserId();
	}

	@Override
	public String registerUserWithGetCurntSession(User details) {
		// details : TRANSIENT => not yet part of L1 cache, does not have db
		// identity(i.e no corresponding rec in db , exists ONLY in java obj heap
		// get session from Session Factory
		Session hibSession = getFactory().getCurrentSession();
		Session hibSession2 = getFactory().getCurrentSession();
		System.out.println(hibSession == hibSession2);// true
		// begin a transaction
		Transaction tx = hibSession.beginTransaction();
		System.out.println("is open " + hibSession.isOpen() + " is connected " + hibSession.isConnected());// t t

		try {
			hibSession.save(details);
			// details : PERSISTENT : part of L1 cache , not yet in db
			// => success !
			tx.commit();// Upon commit , hibernate perform auto dirty checking --session.flush --> since
						// new entity is a part of L1 cache n doesn't have rec in db -- insert query
			System.out.println(
					"after commit : is open " + hibSession.isOpen() + " is connected " + hibSession.isConnected());// f
																													// f

		} catch (RuntimeException e) {
			// => error -- rollback tx
			if (tx != null)
				tx.rollback();
			System.out.println(
					"after rollback  : is open " + hibSession.isOpen() + " is connected " + hibSession.isConnected());// f
																														// f

			// re throw the exception to the caller
			throw e;
		}

		// details : DETACHED
		return "User registered with ID =" + details.getUserId();
	}

	@Override
	public User getUserDetailsById(int userId) {
		User user = null;// user : does not exist!
		// get session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			// Session API : T get(Class<T> entityClass, Serializable id) throws hibexc
			user = session.get(User.class, userId);// int --> Integer ---> Serializable
			user = session.get(User.class, userId);// int --> Integer ---> Serializable
			user = session.get(User.class, userId);// int --> Integer ---> Serializable
			// if id is valid , user : PERSISTENT
			tx.commit();// comment n observe the issue !!!!
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return user;// user : DETACHED
	}

	@Override
	public List<User> getAllUserDetails() {
		String jpql = "select u from User u";
		List<User> users = null;
		// get session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class).getResultList();
			// users=session.createQuery(jpql, User.class).getResultList();
			// users=session.createQuery(jpql, User.class).getResultList();
			// users : List of PERSISTENT entities
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return users;// users : List of DETACHED entities
	}

	@Override
	public List<User> getUsersByDateAndRole(LocalDate beginDate, LocalDate endDate, Role role1) {
		List<User> users = null;
		String jpql = "select u from User u where u.regDate between :start and :end and u.userRole=:role";
		// get session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class).setParameter("start", beginDate).setParameter("end", endDate)
					.setParameter("role", role1).getResultList();
			// users : list of PERSISTENT entities
			tx.commit();// hib performs auto dirty chking --session.flush() --if there are any changes
						// (currently none!) --then will fire DML --session.close() --> pooled out db
						// cn rets to the pool --L1 cache is destroyed !
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();// hib DOES NOT perform auto dirty chking --no session.flush() --if there are
								// any changes
			// (currently none!) --then will NOT fire DML --session.close() --> pooled out
			// db
			// cn rets to the pool --L1 cache is destroyed !
			throw e;
		}
		return users;
	}

	@Override
	public List<String> getUserNamesByRole(Role role) {
		List<String> names = null;
		String jpql = "select u.firstName from User u where u.userRole=:rl";
		// get session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			names = session.createQuery(jpql, String.class).setParameter("rl", role).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return names;
	}

	@Override
	public List<User> getUsersByDateAndRole2(LocalDate beginDate, Role role) {
		List<User> users = null;
		String jpql = "select new pojos.User(lastName,regAmount,regDate) from User u where u.regDate > :date and u.userRole=:rl";
		// get session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class).setParameter("date", beginDate).setParameter("rl", role)
					.getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return users;
	}

	@Override
	public String changePassword(String email, String oldPwd, String newPwd) {
		User user = null;
		String message = "Changing password failed!";
		String jpql = "select u from User u where u.email=:em and u.password=:pass";
		// get session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			user = session.createQuery(jpql, User.class).setParameter("em", email).setParameter("pass", oldPwd)
					.getSingleResult();
			// => login success !
			// user : PERSISTENT
			user.setPassword(newPwd);// modifying the state of the persistent entity
			tx.commit();// hib performs auto dirty chking --session.flush() --> state of entity is dirty
						// --> results in to update query
			message="Password changed !";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		// user : DETACHED
		user.setPassword("99999999");// hib CAN NOT track the changes made to detached entity !!!!
		return message;
	}

	@Override
	public String applyDiscountBulkUpdate(LocalDate endDate, double discount) {
		String mesg="Bulk updation failed!!!!!!!!!!!";
		String jpql="update User u set u.regAmount=u.regAmount-:disc where u.regDate < :dt";
		// get session from SF
				Session session=getFactory().getCurrentSession();
				//begin tx
				Transaction tx=session.beginTransaction();
				try {
					int updateCount=session.createQuery(jpql).
							setParameter("disc", discount).
							setParameter("dt",endDate)
							.executeUpdate();
					mesg="Updated "+updateCount+" users successfully!";
					tx.commit();
				} catch (RuntimeException e) {
					if(tx != null)
						tx.rollback();
					throw e;
				}
		return mesg;
	}
	

}
