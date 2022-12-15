package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CategoryDaoImpl;
import dao.ProductDaoImpl;
import pojos.Category;
import pojos.Product;

public class AddProductToExistingCategory {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			ProductDaoImpl dao = new ProductDaoImpl();
			System.out.println("Enter category id");
			long id = sc.nextLong();
			// productName , double price, String description, LocalDate expDate
			sc.nextLine();
			System.out.println("Enter product name");
			String name = sc.nextLine();
			System.out.println("Enter product price");
			double price = sc.nextDouble();
			sc.nextLine();
			System.out.println("Enter product desc");
			String desc = sc.nextLine();
			System.out.println("Enter product's exp date : yyyy-MM-dd");
			LocalDate expDate = LocalDate.parse(sc.next());
			if (expDate.isAfter(LocalDate.now())) {
//valid date 
				System.out.println(dao.addProductToCategory(id, new Product(name, price, desc, expDate)));
			}
			else
				System.out.println("Invalid exp date!!!!!!!!!!!!!!!!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
