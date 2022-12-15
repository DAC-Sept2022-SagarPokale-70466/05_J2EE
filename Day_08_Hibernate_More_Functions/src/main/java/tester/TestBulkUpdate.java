package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
import pojos.Role;

import static java.time.LocalDate.parse;

public class TestBulkUpdate {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			// create dao instance
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println("Enter  date n discount");
			System.out.println(dao.applyDiscountBulkUpdate(parse(sc.next()),sc.nextDouble()));
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
