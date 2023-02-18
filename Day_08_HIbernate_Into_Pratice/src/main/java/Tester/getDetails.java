/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 30-Nov-2022 4:39:12 PM
*/

package Tester;

import static utils.HibernateUtil.getFactory;

import java.util.Scanner;

import javax.transaction.SystemException;

import org.hibernate.SessionFactory;

import dao.shopImplementation;

public class getDetails {

	public static void main(String[] args) throws SystemException {

		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {

			System.out.println("Inside 2nd Try block");
			shopImplementation shop = new shopImplementation();
			shop.getProduct().forEach(System.out::println);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

	}

}
