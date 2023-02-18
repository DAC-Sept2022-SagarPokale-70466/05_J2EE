package dao;

import static utils.HibernateUtils.getFactory;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Category;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public String createNewCategory(Category cat) {
		String msg = "Category addition Failed";
		Session hibSess = getFactory().getCurrentSession();
		Transaction tx = hibSess.beginTransaction();
		try {
			hibSess.persist(cat);
			tx.commit();
			msg = "Category addition successful";
		}catch(RuntimeException r) {
			if(tx!=null)
				tx.rollback();
			throw r;
		}
		return msg;
	}

	@Override
	public List<Category> displayAllCat() {
		List<Category> categories = new ArrayList<>();
		String jpql = "select c from Category c";
		Session hibSess = getFactory().getCurrentSession();
		Transaction tx = hibSess.beginTransaction();
		try {
			categories = hibSess.createQuery(jpql, Category.class).getResultList();
			tx.commit();
		}catch(RuntimeException r) {
			if(tx!=null)
				tx.rollback();
			throw r;
		}
		return categories;
	}

}
