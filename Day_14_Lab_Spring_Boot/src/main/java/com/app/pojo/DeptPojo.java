/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 07-Dec-2022 4:27:46 PM
*/

package com.app.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "dept")
@Data
public class DeptPojo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "dept_name")
	private String name;

	@Column(name = "dept_location")
	private String location;

	@OneToMany(mappedBy = "dept", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
	private List<EmpPojo> emp = new ArrayList<>();

	public DeptPojo() {

	}

	public DeptPojo(Integer id, String name, String location, List<EmpPojo> emp) {
		this.id = id;
		this.name = name;
		this.location = location;
//		this.emp = emp;
	}

}
