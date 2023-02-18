/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 14-Jan-2023 8:12:14 PM
*/

package com.app.pojo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "User")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String Email;

	private String password;

	private String securityQue;

	private String First_name;

	private String Last_name;

	private String gender;

	private int mobile_no;

	private String Blood_Group;

	private Date DOB;

	@OneToOne(mappedBy = "userid", cascade = CascadeType.ALL, orphanRemoval = true)
	private Patient patient;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Address address;

}