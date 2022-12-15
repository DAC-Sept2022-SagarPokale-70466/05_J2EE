/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 29-Nov-2022 4:18:49 PM
*/

package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;
import org.hibernate.SessionFactory;
import dao.UserDaoImplementation;
import pojo.Role;
import pojo.User;

public class RegisterNewUser {
	public static void main(String[] args) {
		try (SessionFactory sf = getFactory()) {
			UserDaoImplementation dao = new UserDaoImplementation();
			System.out.println(
					"Enter User Details :UserID, firstname, lastname, email,password, password, userRole, date ");
			Scanner sc = new Scanner(System.in);
			User newUser = new User(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next(),
					Role.valueOf(sc.next()), LocalDate.parse(sc.next()));

			System.out.println(dao.registerUser(newUser));
		} catch (Exception e) {

		}
	}
}
