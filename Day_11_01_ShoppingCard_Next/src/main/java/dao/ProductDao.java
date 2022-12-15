package dao;

import pojos.Product;

public interface ProductDao {
//add a method to add a product to the existing category
	String addProductToCategory(long categoryId, Product newProduct);

	// Remove a product from a Category
	String removeProduct(long categoryId, long productId);
}
