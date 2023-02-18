/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 28-Dec-2022 8:12:59 PM
*/

package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entity.Category;
import com.app.entity.Post;
import com.app.entity.User;

public interface PostRepo extends JpaRepository<Post, Integer> {

	List<Post>  findByUser(User user);
	
	List<Post> findByCategory(Category category);

	@Query("select p from Post p where p.title like :key")
	List<Post> seachByTitle(@Param("key") String title);
}
