/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 27-Dec-2022 11:34:06 PM
*/

package com.app.payloads;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDTO {

	
	private Integer categoryId;
	
	@NotBlank
	@Size(min = 4)
	private String categoryTitle;
	
	@NotBlank
	@Size(max = 50)
	private String categoryDescription;

}
