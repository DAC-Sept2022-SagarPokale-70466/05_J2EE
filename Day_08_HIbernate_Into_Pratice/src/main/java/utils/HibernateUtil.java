/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 30-Nov-2022 4:47:18 PM
*/

package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory session;

	static {
		session = new Configuration().configure().buildSessionFactory();
		System.out.println("Session Created");
	}

	public static SessionFactory getFactory() {
		return session;
	}
}
