package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
import pojos.Role;
import pojos.User;

public class RegisterNewUser {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			// create dao instance
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println(
					"Enter user details : firstName,  lastName,  email,  password,  confirmPassword,  userRole, regAmount,  regDate(yyyy-MM-dd)");
			User newUser = new User(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(),
					Role.valueOf(sc.next().toUpperCase()), sc.nextDouble(), LocalDate.parse(sc.next()));
			System.out.println("user id "+newUser.getUserId());//null
			newUser.setUserId(200);
			System.out.println(dao.registerUser(newUser));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
