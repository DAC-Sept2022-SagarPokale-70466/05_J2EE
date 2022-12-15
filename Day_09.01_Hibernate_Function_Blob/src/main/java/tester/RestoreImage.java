package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
import pojos.Role;

import static java.time.LocalDate.parse;

public class RestoreImage {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			// create dao instance
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println("Enter  user id");
			int userId=sc.nextInt();
			sc.nextLine();//to read off the pending new line from scanner's buffer
			System.out.println("Enter new file name to store image data loaded from db");
			System.out.println(dao.restoreImage(userId, sc.nextLine()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
