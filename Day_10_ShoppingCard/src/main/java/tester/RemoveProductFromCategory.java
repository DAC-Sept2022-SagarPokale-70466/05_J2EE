package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.ProductDaoImpl;

public class RemoveProductFromCategory {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			ProductDaoImpl productDao=new ProductDaoImpl();
			System.out.println("Enter category id n product id");
			System.out.println(productDao.removeProduct(sc.nextLong(),sc.nextLong()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
