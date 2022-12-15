/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 07-Dec-2022 4:15:38 PM
*/

package com.app.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Emp_table")
@Data
public class EmpPojo {

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

	@ManyToOne
	@JoinColumn(name = "dept_no", nullable = false)
	private DeptPojo dept;

	public EmpPojo(Integer id, String firstName, String lastName, String address, Date joinDate, int salary,
			DeptPojo dept) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.joinDate = joinDate;
		this.salary = salary;
		this.dept = dept;
	}

	public EmpPojo() {
	}

	
	
}
