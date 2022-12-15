package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Category;
import pojos.Product;
import static utils.HibernateUtils.getFactory;

public class ProductDaoImpl implements ProductDao {

	@Override
	public String addProductToCategory(long categoryId, Product newProduct) {

		String mesg = "Adding product to category failed !!!!!!!!!!!!";
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a tx
		Transaction tx = session.beginTransaction();
		try {

			// get category from it's id
			Category category = session.get(Category.class, categoryId);

			if (category != null) {
				// =>valid category : PERSISTENT
				// establish a bi dir asso between Category <----> Product
				category.addProduct(newProduct); // Our Own Created-> To Establish Bi-directional Associatation

				// since no cascading is specified --must persist the rec explicitly!
//				session.persist(newProduct);				// Even after Commiting  -> Will Automatically Casceded becanuse Cascade is ON Inside Catergory
				mesg = "added product to the category " + category.getCategoryName();
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String removeProduct(long categoryId, long productId) {
		String mesg = "removing product failed !!!!!!!!!!!!!!";
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a tx
		Transaction tx = session.beginTransaction();

		try {
			// get category from id
			Category category = session.get(Category.class, categoryId);
			// get product from id
			Product product = session.get(Product.class, productId);

			if (category != null && product != null) {
				// valid !
//				Add  a Check here
				if (product.getProductCategory().getId() == category.getId())
					// call helper : remove product
					category.removeProduct(product); // If Orphan removal is flase then the only change is FK. willl be
														// Marked as NULL and if orphan removal is ON then it will
														// remove entire product
				mesg = "Removed product " + product.getProductName() + " from category " + category.getCategoryName();
			} else {
				mesg = "Mismatched Inputs";
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}
