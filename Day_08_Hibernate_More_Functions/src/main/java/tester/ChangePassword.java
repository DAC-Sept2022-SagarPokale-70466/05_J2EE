package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
import pojos.Role;

import static java.time.LocalDate.parse;

public class ChangePassword {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			// create dao instance
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println("Enter  email , old password , new password");
			System.out.println(dao.changePassword(sc.next(), sc.next(), sc.next()));
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
