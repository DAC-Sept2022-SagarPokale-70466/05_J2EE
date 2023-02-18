/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 14-Jan-2023 8:24:33 PM
*/

package com.app.pojo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Patient")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
	@Id
	@Column(name = "patient_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String symptoms;

	private String appointment_time;

	private boolean admit_status;

	private boolean appointment_status;

	private boolean action;

	@ManyToOne
	@JoinColumn(name = "ward_id")
	private Ward ward;
	
	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;

	@OneToOne
	@JoinColumn(name = "id", nullable = false)
	private User userid;
}


//
//@OneToMany(mappedBy = "patients", cascade = CascadeType.ALL)
//private Set health_history= new HashSet();
//
