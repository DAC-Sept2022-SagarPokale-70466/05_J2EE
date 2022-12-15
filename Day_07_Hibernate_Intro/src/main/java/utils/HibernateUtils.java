/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 29-Nov-2022 3:04:18 PM
*/

package utils;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
public class HibernateUtils {
	private static SessionFactory factory;
	
	static {
		System.out.println("Inside static initializer block");
		factory = new Configuration().configure().buildSessionFactory();
//										null			configure from hibernate.cfg.xml	
		
	}
	
	public static SessionFactory getFactory() {
		return factory;
	}
	
}
