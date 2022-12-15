package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import static utils.HibernateUtils.getFactory;

import pojos.Category;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public String addNewCategory(Category newCategory) {
		
		String mesg = "Adding new category failed!!!!!!!!!!";
		// 1 get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin tx
		Transaction tx = session.beginTransaction();
		try {
			// add new category to the shop
			session.persist(newCategory);		// Category added
			tx.commit();// insert
			mesg = "Added new category with id=" + newCategory.getId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String deleteCategory(String categoryName) {
		
		String mesg = "deleting category failed !!!!";
		String jpql = "select c from Category c where c.categoryName=:nm";
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a tx
		Transaction tx = session.beginTransaction();
		
		try {
			// 3. get category from it's name
			Category catgeory = session.createQuery(jpql, Category.class).setParameter("nm", categoryName).getSingleResult();
//																Select Quary
			// category : PERSISTENT
			// => no exc => category found !
			session.delete(catgeory); // category : REMOVED	(Marking the entity for removal)
			tx.commit(); // hib perform dirty chking --> session.flush --> delete query , session.close
							// --> L1 cache destroyed , connection returns to the pool
			// category : TRANSIENT
			mesg = "Deleted the category with name " + categoryName;
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}// category : marked for GC !

	@Override
	public Category getCategoryDetails(String categoryName) {
		Category category = null;
		String jpql = "select c from Category c where c.categoryName=:nm";
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a tx
		Transaction tx = session.beginTransaction();
		try {
			category = session.createQuery(jpql, Category.class).
					setParameter("nm", categoryName).getSingleResult();
			//category : persistent
			tx.commit();		// session.close()
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return category;//category : DETACHED
	}
	@Override
	public Category getCategoryWithProducts(String categoryName) {
		Category category = null;
		String jpql = "select c from Category c where c.categoryName=:nm";
//		String jpql = "select c from Category c left outer join fetch c.products where c.categoryName=:nm";			// 3rd Solution
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a tx
		Transaction tx = session.beginTransaction();
		try {
			category = session.createQuery(jpql, Category.class).setParameter("nm", categoryName).getSingleResult();
			//category : persistent
			
			category.getProducts().size();		//simply provide a hint : fetch size of the collection.
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return category;//category : DETACHED
	}
}
