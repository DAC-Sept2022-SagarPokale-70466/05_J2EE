package dao;

import java.util.List;

import pojos.Blog;
import pojos.User;

public interface UserDao {
	User authenticateUser(String email,String pass);
	String registerUser(User user);
	public String addBlog(long categoryId, Blog newProduct,String email);
	public List<Blog> displayBlogs();
	Blog blogById(Long id);
	int updateBlog(Long id, String title, String content);
	int deleteBlog(Long id);
	Blog findBlog(String title);
}
