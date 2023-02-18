/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 01-Jan-2023 1:45:44 PM
*/

package com.app.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.payloads.ApiResponce;
import com.app.payloads.CommentDTO;
import com.app.service.CommentService;

@RestController
@RequestMapping("/api/v1/")
public class CommentController {

	@Autowired
	private CommentService commentService;

	@PostMapping("/post/{postId}/comments")
	public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO comment, @PathVariable Integer postId) {
		System.out.println("Inside the Create Comment ");
		CommentDTO createComment = this.commentService.createComment(comment, postId);
		return new ResponseEntity<CommentDTO>(createComment, HttpStatus.CREATED);
	}

	@DeleteMapping("/comments/{commentId}")
	public ResponseEntity<ApiResponce> deleteComment(@PathVariable Integer commentId) {
		this.commentService.deleteComment(commentId);
		return new ResponseEntity<ApiResponce>(new ApiResponce("Comment Deleted Successfully", true), HttpStatus.OK);
	}

}
