/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 01-Dec-2022 3:31:49 PM
*/

package dao;

import java.util.List;

import pojo.Product;
import org.hibernate.*;
import static utils.HibernateUtils.getFactory;

public class ProductDaoImpl implements ProductDao {

	@Override
	public List<Product> listAllProducts() {

		List<Product> products;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String jpql = "select p from Product p";
		try {
			products = session.createQuery(jpql,Product.class).getResultList();
//			Products : List of pesistant Entities
			tx.commit();		// Hib performs auto dirty checking session.flush() -> no change -> No DML will be fired -> L1 cache is destroyed n connection returns to the pool
			System.out.println("INside the dao implementation");
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return products; //			Products : List of Detached Entities
	}

}
