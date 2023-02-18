/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 28-Dec-2022 12:01:28 AM
*/

package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.payloads.ApiResponce;
import com.app.payloads.CategoryDTO;
import com.app.service.CategoryService;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/")
	public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDto) {
		CategoryDTO createCatergory = this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDTO>(createCatergory, HttpStatus.CREATED);
	}

	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDto,
			@PathVariable Integer catId) {
		CategoryDTO updatedCatergory = this.categoryService.updateCategory(categoryDto, catId);
		return new ResponseEntity<CategoryDTO>(updatedCatergory, HttpStatus.OK);
	}

	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponce> deleteCategory(@PathVariable Integer catId) {
		this.categoryService.deleteCategory(catId);
		return new ResponseEntity<ApiResponce>(new ApiResponce("Category Deleted Successfully", true), HttpStatus.OK);
	}

	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDTO> getCategory(@PathVariable Integer catId) {
		CategoryDTO getCatergory = this.categoryService.getCategory(catId);
		return new ResponseEntity<CategoryDTO>(getCatergory, HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<CategoryDTO>> getCategory() {
		List<CategoryDTO> catergory = this.categoryService.getCategory();
		return ResponseEntity.ok(catergory);
	}
}
