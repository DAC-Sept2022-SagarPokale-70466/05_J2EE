/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 01-Jan-2023 1:34:48 PM
*/

package com.app.service.impl;

import org.hibernate.graph.CannotBecomeEntityGraphException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Comment;
import com.app.entity.Post;
import com.app.excetions.ResourceNotFoundException;
import com.app.payloads.CommentDTO;
import com.app.repository.CommentRepo;
import com.app.repository.PostRepo;
import com.app.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostRepo postRepo;

	@Autowired  CommentRepo commentRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public CommentDTO createComment(CommentDTO commentDto, Integer postId) {

		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", postId));
		Comment comment = this.mapper.map(commentDto, Comment.class);
		comment.setPost(post);
		Comment save = this.commentRepo.save(comment);

		return this.mapper.map(save, CommentDTO.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment com = this.commentRepo.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment", "CommentId", commentId));
		this.commentRepo.delete(com);
	}

}
