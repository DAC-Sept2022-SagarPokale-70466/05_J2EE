/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 01-Jan-2023 1:31:42 PM
*/

package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
