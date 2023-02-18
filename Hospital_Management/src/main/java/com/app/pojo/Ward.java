/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 14-Jan-2023 11:02:33 PM
*/

package com.app.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "ward")
@Getter
@Setter
@NoArgsConstructor
public class Ward {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ward_Id")
	private int Id;
	@Column(name = "ward_type",length = 45)
	private String wardType;
	@Column(name = "allocated_bed",length = 45)
	private String allocatedBed;
	@Column(name = "ward_charges")
	private double wardCharges;
	
	@OneToMany(mappedBy = "ward", cascade = CascadeType.ALL)
	private Set<Patient> patients= new HashSet();
}
