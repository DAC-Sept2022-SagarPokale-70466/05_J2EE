/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 30-Nov-2022 4:39:12 PM
*/

package Tester;

import org.hibernate.SessionFactory;

import dao.shopImplementation;
import pojos.Product;

import static utils.HibernateUtil.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import javax.transaction.SystemException;

public class MainTester {

	public static void main(String[] args) throws SystemException {

		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {

			System.out.println("Inside 1st Try block");
			shopImplementation shop = new shopImplementation();
			System.out.println("Enter The values : Name, Desc, Prize, Exp Date");

			Product product = new Product(sc.next(), sc.next(), sc.nextDouble(), LocalDate.parse(sc.next()));
			System.out.println(shop.addItom(product));
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

	}

}
