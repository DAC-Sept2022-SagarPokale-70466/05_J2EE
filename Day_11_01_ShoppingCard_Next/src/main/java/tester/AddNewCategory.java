package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CategoryDaoImpl;
import pojos.Category;

public class AddNewCategory {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			CategoryDaoImpl dao=new CategoryDaoImpl();
			System.out.println("Enter details : categoryName");
			String nm=sc.nextLine();		
			System.out.println("Enter category desc");
			Category transientCategory=new Category(nm,sc.nextLine());
			System.out.println(dao.addNewCategory(transientCategory));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
