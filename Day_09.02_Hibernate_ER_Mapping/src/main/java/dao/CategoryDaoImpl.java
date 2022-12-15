package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import static utils.HibernateUtils.getFactory;

import pojos.Category;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public String addNewCategory(Category newCategory) {
		String mesg="Adding new category failed!!!!!!!!!!";
		// 1 get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin tx
		Transaction tx = session.beginTransaction();
		try {
			//add new category to the shop
			session.persist(newCategory);
			tx.commit();//insert
			mesg="Added new category with id="+newCategory.getId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}
