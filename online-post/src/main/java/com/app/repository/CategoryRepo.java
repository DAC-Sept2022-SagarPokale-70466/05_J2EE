/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 27-Dec-2022 11:35:28 PM
*/

package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

	// Repo is interface -> no need to mention @Repository
}
