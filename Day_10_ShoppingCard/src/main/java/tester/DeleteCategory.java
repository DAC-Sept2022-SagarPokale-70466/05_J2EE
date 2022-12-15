package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CategoryDaoImpl;

public class DeleteCategory {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			CategoryDaoImpl dao=new CategoryDaoImpl();
			System.out.println("Enter category name to delete ");
			String nm=sc.nextLine();					
			System.out.println(dao.deleteCategory(nm));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
