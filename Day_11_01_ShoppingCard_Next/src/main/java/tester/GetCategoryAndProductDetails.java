package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CategoryDaoImpl;
import pojos.Category;

public class GetCategoryAndProductDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			CategoryDaoImpl dao = new CategoryDaoImpl();
			System.out.println("Enter category name to display details ");
			String nm = sc.nextLine();
			Category category = dao.getCategoryWithProducts(nm);
			System.out.println("Category dtls " + category);
			System.out.println("Products : ");
			category.getProducts().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
