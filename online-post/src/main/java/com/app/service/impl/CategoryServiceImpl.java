/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 27-Dec-2022 11:43:57 PM
*/

package com.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Category;
import com.app.excetions.ResourceNotFoundException;
import com.app.payloads.CategoryDTO;
import com.app.payloads.UserDTO;
import com.app.repository.CategoryRepo;
import com.app.service.CategoryService;
import com.app.service.UserService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDTO createCategory(CategoryDTO categoryDto) {

		Category cat = this.modelMapper.map(categoryDto, Category.class);
		Category addedCat = this.categoryRepo.save(cat);
		return this.modelMapper.map(addedCat, CategoryDTO.class);
	}

	@Override
	public CategoryDTO updateCategory(CategoryDTO categoryDto, Integer categoryID) {
		Category cat = this.categoryRepo.findById(categoryID)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Category ID", categoryID));

		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		Category save = this.categoryRepo.save(cat);
		return this.modelMapper.map(save, CategoryDTO.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Category ID", categoryId));

		this.categoryRepo.delete(cat);
	}

	@Override
	public CategoryDTO getCategory(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Category ID", categoryId));

		return this.modelMapper.map(cat, CategoryDTO.class);
	}

	@Override
	public List<CategoryDTO> getCategory() {

		List<Category> findAll = this.categoryRepo.findAll();
		List<CategoryDTO> collect = findAll.stream().map((cat) -> this.modelMapper.map(cat, CategoryDTO.class)).collect(Collectors.toList());
		return collect;
	}

}
