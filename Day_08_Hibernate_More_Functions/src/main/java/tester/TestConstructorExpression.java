package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
import pojos.Role;

import static java.time.LocalDate.parse;

public class TestConstructorExpression {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			// create dao instance
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println("Enter begin date n role");
			System.out.println("Selected  Users : ");
			dao.getUsersByDateAndRole2(parse(sc.next()), Role.valueOf(sc.next().toUpperCase())).forEach(u -> System.out
					.println(u.getLastName() 
							+ " paid : " + u.getRegAmount() + " reged  on " + u.getRegDate()));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
