/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 09-Dec-2022 10:06:13 PM
*/

package com.app.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "employee")
@Data
public class Emp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "ename", unique = true)
	private String firstName;

	@Column(name = "esurname")
	private String lastName;

	@Column(name = "address")
	private String address;

	private Date joinDate;
	private int salary;

	private String dept;

}
