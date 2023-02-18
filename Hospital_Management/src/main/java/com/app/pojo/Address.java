/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 14-Jan-2023 8:39:43 PM
*/

package com.app.pojo;

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
@Table(name = "Address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

		@Id
		@Column(name = "Address_id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;

		private int plotNo;

		private String buildingname;

		private String area_name;

		private String city;

		private String state;
		
		private String country;
		
		private int pincode;

//		@OneToOne
//		@JoinColumn(name = "id", nullable = false)
//		private  User user;
	}	