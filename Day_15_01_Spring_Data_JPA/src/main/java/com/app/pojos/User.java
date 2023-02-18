package com.app.pojos;

import java.util.ArrayList;


import java.util.List;

import javax.persistence.CascadeType;
//will be importing all annotations from this pkg
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "User")
@NoArgsConstructor
@Getter
@Setter
public class User extends BaseEntity {

	@Column(length = 20)
	private String uname;

	@Column(unique = true, length = 20)
	@NotBlank(message = "Email required")
	@Email(message = "Invalid email format!")
	private String email;

	@Column(length = 20, nullable = false)
	private String password;

	@Column(length = 15)
	private String city;

	@Column(length = 10)
	private String contact;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Vehicle> vehicles = new ArrayList<>();

}
