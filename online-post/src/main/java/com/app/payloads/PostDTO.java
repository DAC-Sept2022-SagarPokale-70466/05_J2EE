/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 28-Dec-2022 8:20:17 PM
*/

package com.app.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.app.entity.Comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDTO {

	private Integer postId;

	private String title;

	private String content;

	private String imageName;

	private Date date;

	private CategoryDTO category;

	private UserDTO user;
	
	private Set<CommentDTO> comments = new HashSet<>();

}
