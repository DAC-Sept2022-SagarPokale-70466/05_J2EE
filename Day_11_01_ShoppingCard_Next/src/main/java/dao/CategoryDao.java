package dao;

import pojos.Category;

public interface CategoryDao {
	// add a method to launch new category
	String addNewCategory(Category newCategory);

//add a method to delete   category
	String deleteCategory(String categoryName);

	// get category details
	Category getCategoryDetails(String categoryName);

	// get category details
	Category getCategoryWithProducts(String categoryName);

}
