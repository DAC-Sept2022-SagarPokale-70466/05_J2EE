package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
import pojos.Role;
import pojos.User;

public class DeleteUserDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			// create dao instance
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println("Enter user id to un subsribe");
			System.out.println(dao.deleteUserDetails(sc.nextInt()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
