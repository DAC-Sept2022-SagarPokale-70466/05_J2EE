/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 14-Jan-2023 10:40:01 PM
*/

package com.app.pojo;
import java.time.LocalDate;
import java.util.ArrayList;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="doctors")
@NoArgsConstructor
@Getter
@Setter
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int doctorId;
	
	@Column(nullable = false, length = 100)
	private double doctorFee;
	
	private LocalDate scheduled_start_time;
	
	@OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Patient> patients= new ArrayList<>();
	
	@OneToOne
	@JoinColumn(name = "empid")
	private Employee employee;
	
	
}
