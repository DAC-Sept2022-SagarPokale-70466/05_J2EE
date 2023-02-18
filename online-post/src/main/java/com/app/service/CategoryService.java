/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 27-Dec-2022 11:37:53 PM
*/

package com.app.service;

import java.util.List;

import com.app.payloads.CategoryDTO;

public interface CategoryService{

	public CategoryDTO createCategory(CategoryDTO categoryDto);
	
	public CategoryDTO updateCategory(CategoryDTO categoryDto, Integer categoryID);
	
	public void deleteCategory(Integer categoryId);
	
	CategoryDTO getCategory(Integer categoryId);
	
	List<CategoryDTO> getCategory();
}
