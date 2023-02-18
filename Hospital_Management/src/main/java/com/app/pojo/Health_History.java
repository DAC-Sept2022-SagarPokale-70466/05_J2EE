/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 14-Jan-2023 11:14:32 PM
*/

package com.app.pojo;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="health_history")
@Getter
@Setter
@NoArgsConstructor
public class Health_History {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "health_history_Id")
	private Integer Id;
	
	@Column(length = 300, nullable= false)
	private String diseases;
	
	@Column(name = "appointment_date")
	private LocalDate appointmentDate;
	
	@Column(name = "admit_date")
	private LocalDate admitDate;
	
	@Column(name = "prescription_instruction",length=1000)
	private String  prescriptionInstruction;
	
	@Column(name = "discharge_date")
	private LocalDate dischargeDate;
	
	@CreationTimestamp
	@Column(name = "payment_date")
	private LocalDate paymentDate;
	
	@ManyToOne
	@JoinColumn(name = "id", nullable = false)
	private Patient patients;
	
	@OneToMany(mappedBy = "healthHistory", cascade = CascadeType.ALL)
	private Set<Medicine> medicines= new HashSet();
}