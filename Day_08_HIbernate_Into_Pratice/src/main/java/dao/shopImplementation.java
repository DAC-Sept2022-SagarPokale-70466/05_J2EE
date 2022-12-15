/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 30-Nov-2022 4:46:31 PM
*/

package dao;

import static utils.HibernateUtil.getFactory;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.SystemException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Product;

public class shopImplementation implements eShop {

	@Override
	public String addItom(Product product) throws IllegalStateException, SystemException {

		Session session = getFactory().getCurrentSession();

		org.hibernate.Transaction tx = session.beginTransaction();

		LocalDate saveDate = product.getExpDate();
		System.out.println(saveDate);
		
		try {
			if (saveDate.isAfter(LocalDate.now())) {
				session.save(product);
				tx.commit();
			} else {
				return "Expiration Date is Invalidated";
			}
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			if(tx != null)
				tx.rollback();
		}

		return "Saved SuccessFully";
	}

	@Override
	public List<Product> getProduct() {
		String jpql = "select p from Product p";
		List<Product> product = null;
		
		Session session = getFactory().getCurrentSession();
		Transaction  tx = session.beginTransaction();
		
		try {
			product =  session.createQuery(jpql, Product.class).getResultList();
			tx.commit();
		}catch(RuntimeException e) {
			if(session != null)
				session.clear();
		}
		return product;
	}

}
