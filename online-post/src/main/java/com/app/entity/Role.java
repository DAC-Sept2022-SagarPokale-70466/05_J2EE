/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 01-Jan-2023 2:48:02 PM
*/

package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Role {
		
	@Id
	private int id;
		
	private String name;
	
}
