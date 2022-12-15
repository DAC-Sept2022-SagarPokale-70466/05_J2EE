package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CategoryDaoImpl;
import pojos.Category;
import pojos.Product;

public class AddNewCategoryWithProducts {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {

			CategoryDaoImpl dao = new CategoryDaoImpl();
			System.out.println("Enter details : categoryName");
			String nm = sc.nextLine();
			System.out.println("Enter category desc");
			Category transientCategory = new Category(nm, sc.nextLine());
			// productName , double price, String description, LocalDate expDate
			// sc.nextLine();

			for (int i = 0; i < 2; i++) {
				System.out.println("Enter product name");
				String name = sc.nextLine();
				System.out.println("Enter product price");
				double price = sc.nextDouble();
				sc.nextLine();
				System.out.println("Enter product desc");
				String desc = sc.nextLine();
				System.out.println("Enter product's exp date : yyyy-MM-dd");
				LocalDate expDate = LocalDate.parse(sc.next());

				// valid date
				if (expDate.isAfter(LocalDate.now())) {
					// add product to the category : establish bi dir link
					transientCategory.addProduct(new Product(name, price, desc, expDate));		// Adding the Multi-Product to Catergory 
				} else
					System.out.println("Invalid exp date!!!!!!!!!!!!!!!!");
				sc.nextLine();

			}
			// call dao's method
			dao.addNewCategory(transientCategory);			// Adding the Catergory to DB

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
