package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
import pojos.Role;

import static java.time.LocalDate.parse;

public class StoreImage {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			// create dao instance
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println("Enter  user id");
			int userId=sc.nextInt();
			sc.nextLine();//to read off the pending new line from scanner's buffer
			System.out.println("Enter file name");
			System.out.println(dao.storeImage(userId, sc.nextLine()));
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
