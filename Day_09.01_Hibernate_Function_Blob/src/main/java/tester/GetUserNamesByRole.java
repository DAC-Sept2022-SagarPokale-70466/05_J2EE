package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
import pojos.Role;

import static java.time.LocalDate.parse;

public class GetUserNamesByRole {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			// create dao instance
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println("Enter  role");
			System.out.println("Selected  User names  : ");
			dao.getUserNamesByRole(Role.valueOf(sc.next().toUpperCase()))
			.forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
