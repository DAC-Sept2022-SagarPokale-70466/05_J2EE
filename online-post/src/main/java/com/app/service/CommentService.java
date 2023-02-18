/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 01-Jan-2023 1:32:53 PM
*/

package com.app.service;

import com.app.payloads.CommentDTO;

public interface CommentService {
	
	CommentDTO createComment(CommentDTO commentDto, Integer postId);
	
	void deleteComment(Integer commentId);
}
