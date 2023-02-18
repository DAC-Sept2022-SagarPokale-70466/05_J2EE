package dao;

import static utils.HibernateUtils.getFactory;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Blog;
import pojos.Category;
import pojos.User;

public class UserDaoImpl implements UserDao {
	@Override
	public String addBlog(long categoryId, Blog newBlog,String email) {
		String mesg = "Adding blog to category failed !!!!!!!!!!!!";
		String jpql = "select u from User u where u.email=:em";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			User u=session.createQuery(jpql, User.class).setParameter("em", email).getSingleResult();
			Category category = session.get(Category.class, categoryId);
			
			if (category != null) {
				u.addBlogToUser(newBlog);
				category.addBlogToCategory(newBlog);
				mesg = "added blog to the category" + category.getTitle();
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
	public List<Blog> displayBlogs() {
		String jpql="select b from Blog b";
		List<Blog> list = new ArrayList<Blog>();
		Session session = getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		try {	
			list = session.createQuery(jpql, Blog.class).getResultList();
			tx.commit();
		}catch(RuntimeException r) {
			if(tx!=null)
				tx.rollback();
			throw r;
		}
		return list;
	}

	@Override
	public String registerUser(User user) {
		String msg ="User registration Failed";
		Session hibSess = getFactory().getCurrentSession();
		Transaction tx = hibSess.beginTransaction();
		try {
			hibSess.persist(user);
			tx.commit();
			msg = "User Registration Successful";
		}catch(RuntimeException r) {
			if(tx!=null)
				tx.rollback();
			throw r;
		}
		return msg;
	}

	@Override
	public User authenticateUser(String email, String pass) {
		User u;
		String jpql="select u from User u where u.email=:em and u.password=:pass";
		Session hibSess = getFactory().getCurrentSession();
		
		Transaction tx = hibSess.beginTransaction();
		try {
			u=hibSess.createQuery(jpql, User.class).setParameter("em", email).setParameter("pass", pass).getSingleResult();
			tx.commit();
		}catch(RuntimeException r) {
			if(tx!=null)
				tx.rollback();
			throw r;
		}
		return u;
	}
	@Override
	public Blog blogById(Long id) {
		Blog b;
		Session hibSess = getFactory().getCurrentSession();
		Transaction tx = hibSess.beginTransaction();
		try {
			b=hibSess.get(Blog.class, id);
			tx.commit();
		}catch(RuntimeException r) {
			if(tx!=null)
				tx.rollback();
			throw r;
		}
		return b;
	}
	@Override
	public int updateBlog(Long id, String title, String content) {
		int i=0;
		Session hibSess = getFactory().getCurrentSession();
		Transaction tx = hibSess.beginTransaction();
		try {
			Blog b=hibSess.get(Blog.class, id);
			b.setTitle(title);
			b.setContents(content);
			tx.commit();
			i=1;
		}catch(RuntimeException r) {
			if(tx!=null)
				tx.rollback();
			throw r;
		}
		return i;
	}
	@Override
	public int deleteBlog(Long id) {
		int i=0;
		Session hibSess = getFactory().getCurrentSession();
		Transaction tx = hibSess.beginTransaction();
		try {
			Blog b=hibSess.get(Blog.class, id);
			Category cat=b.getCategory();
			User u=b.getUser();
			cat.removeBlog(b);
			u.removeBlog(b);
			tx.commit();
			i=1;
		}catch(RuntimeException r) {
			if(tx!=null)
				tx.rollback();
			throw r;
		}
		return i;
	}
	@Override
	public Blog findBlog(String title) {
		Blog blog=new Blog();
		System.out.println("in findblog "+title);
		String jpql = "select b from Blog b where b.title=:t";
		Session hibSess = getFactory().getCurrentSession();
		Transaction tx = hibSess.beginTransaction();
		try {
			blog=hibSess.createQuery(jpql, Blog.class).setParameter("t", title).getSingleResult();
			System.out.println(blog);
			tx.commit();
		}catch(RuntimeException r) {
			if(tx!=null)
				tx.rollback();
			throw r;
		}
		return blog;
	}

}
