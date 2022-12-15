/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 29-Nov-2022 3:10:47 PM
*/

package tester;
import static utils.HibernateUtils.getFactory;

import org.hibernate.SessionFactory;
public class TestHibernate {

	public static void main(String[] args) {
		
		try(SessionFactory sf = getFactory()){
			System.out.println("Session Factory : Hibernate up and running !!!!!!!!!!!!!!!!!");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
