/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 26-Dec-2022 11:41:21 PM
*/

package com.app.payloads;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class UserDTO {
	
	
	private int id;
	
	@NotEmpty
	@Size(min = 5,message = "UserName must be at least 5 Character")
	private String name;
	
	@NotEmpty
	@Email(message = "Invalid Email Address")
	private String email;
	
	@NotEmpty
	@Size(min = 3, max = 15,message = "Password must be between 3 - 15")
//	@Pattern(regexp = )
	private String password;
	
	@NotEmpty
	private String about;
	
	private Set<RoleDTO>  roles = new HashSet<>();
	
	
	// Just to ingore the password while returning toward Front-end
	@JsonIgnore
	public String getPassword()
	{
		return this.password;
	}
	
	@JsonProperty // Will set the object in serialization
	public void setPassword(String password)
	{
		this.password = password;
	}
}
