/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 01-Dec-2022 3:42:50 PM
*/

package beans;

import java.util.List;

import dao.ProductDaoImpl;
import pojo.Product;

public class ProductBeance {
//	State : Fields : dep
	private ProductDaoImpl productDao;
//	default Constructor : Invoked by WC -- Trigger  : JSP : useBean

	public ProductBeance() {
		productDao = new ProductDaoImpl();
		System.out.println("Product Dao and Bean Created  : ) ");
	}
	
//	B.L Methods for getting all products from the dao layer
	
	public List<Product> fetchProduct(){
		System.out.println("In B.L, Fetch Products : ");
		return productDao.listAllProducts();
	}
	
}
