package com.app.dto;

import javax.validation.constraints.NotNull;

import com.app.pojos.BaseEntity;
import com.app.pojos.Role;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonInclude(Include.NON_EMPTY) // will not include any null valued or empty properties during ser.
public class UserDto extends BaseEntity {

	private String firstName;
	private String lastName;
	private String email;
	@JsonProperty(access = Access.WRITE_ONLY) // skips the field/property during serialization
	private String password;
	private Role userRole;

	public UserDto(String firstName, String lastName, String email, String password, Role userRole) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.userRole = userRole;
	}

	public UserDto(String firstName, String lastName, String email, Role userRole) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userRole = userRole;
	}

	public UserDto(Long id, String firstName2, String lastName2, String email2,
			@NotNull(message = "user role must be supplied!") Role userRole2) {
		super();
		this.setId(id);
		this.firstName = firstName2;
		this.lastName = lastName2;
		this.email = email2;
		this.userRole = userRole2;
	}

}
