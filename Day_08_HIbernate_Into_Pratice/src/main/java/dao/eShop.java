/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 30-Nov-2022 4:45:36 PM
*/

package dao;

import java.util.List;

import javax.transaction.SystemException;

import pojos.Product;

public interface eShop {

	public String addItom(Product prodct) throws IllegalStateException, SystemException;
	
	public List<Product> getProduct();
	
}
