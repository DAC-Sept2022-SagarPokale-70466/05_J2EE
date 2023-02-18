package dao;

import java.util.List;

import pojos.Category;

public interface CategoryDao {
	String createNewCategory(Category cat);
	List<Category> displayAllCat();
	
}
