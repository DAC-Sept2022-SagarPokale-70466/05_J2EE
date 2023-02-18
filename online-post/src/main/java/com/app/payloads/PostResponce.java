/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 30-Dec-2022 10:14:19 PM
*/

package com.app.payloads;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostResponce {

	private List<PostDTO> content;
	private int pageNumber;
	private int pageSize;
	private long totalElements;
	private int totalPages;
	
	private boolean lastPage;
}
