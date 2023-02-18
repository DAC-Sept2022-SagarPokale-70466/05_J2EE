/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 28-Dec-2022 8:19:44 PM
*/

package com.app.service;

import java.util.List;

import com.app.entity.Post;
import com.app.payloads.PostDTO;
import com.app.payloads.PostResponce;

public interface PostService {

//	Create
	PostDTO createPost(PostDTO postDto, Integer userId, Integer categoryId);

//	Update
	PostDTO updatePost(PostDTO postDto, Integer postId);

//	Delete
	void deletePost(Integer postId);

//	Get all post
	PostResponce getAllPost(Integer pageNumber, Integer pageSize, String sortBy,String sortDir);

	PostDTO getPostById(Integer postId);

	List<PostDTO> getPostsByCategory(Integer categoryId);

	// get all post by user
	List<PostDTO> getPostsByUser(Integer userId);

//	Seach inside post
	List<PostDTO> searchPosts(String keyword);
}
