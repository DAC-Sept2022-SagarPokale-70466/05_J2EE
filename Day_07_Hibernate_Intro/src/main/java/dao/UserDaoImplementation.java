/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 29-Nov-2022 4:04:32 PM
*/

package dao;

import static utils.HibernateUtils.getFactory;
import org.hibernate.*;
import pojo.User;

public class UserDaoImplementation implements UserDao {

	@Override
	public String registerUser(User details) {
//		Get the session from session factory
		Session hibSession = getFactory().openSession();
// Session hibSession = getFactory().getCurrentSession();
//		Begin a transaction
		Transaction tx = hibSession.beginTransaction();

		try {
			hibSession.save(details);
//			=> Success;
			tx.commit();
		} catch (RuntimeException e) {
//			=> error -- rollback tx
			if (tx != null)
				tx.rollback();
//			re throw the exception to the caller
			throw e;
		} finally {
			if (hibSession != null)
				hibSession.clear();
		}
		return "User Registed with ID = " + details.getUserId();
	}

}
