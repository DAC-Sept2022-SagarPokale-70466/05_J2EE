/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 14-Jan-2023 11:12:46 PM
*/

package com.app.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "medicines")
@Getter
@Setter
@NoArgsConstructor
public class Medicine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "medicine_Id")
	private int Id;
	@Column(name = "medicine_name", length = 500)
	private String medicineName;
	private String duration;
	private int qty;
	@Column(name = "medicine_charges")
	private double medicineCharges;

	@ManyToOne
	@JoinColumn(name = "health_history_Id", nullable = false)
	private Health_History healthHistory;
}
