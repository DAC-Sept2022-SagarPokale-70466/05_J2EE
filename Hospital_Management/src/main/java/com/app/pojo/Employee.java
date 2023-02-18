/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 14-Jan-2023 8:13:31 PM
*/

package com.app.pojo;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Emplyee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Employee {

	@Id
	@Column(name = "Emp_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empid;

//	private User User_id;

	private String role;

	private String Qualificaton;

	private int salary;

	private LocalDate Hiredate;

	private boolean status;

	@OneToOne
	@JoinColumn(name = "id", nullable = false)
	private User userid;
}