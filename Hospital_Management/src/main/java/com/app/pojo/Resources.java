/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 15-Jan-2023 12:10:37 AM
*/

package com.app.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "resources")
@Getter
@Setter
@NoArgsConstructor
public class Resources {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resource_Id")
	private int Id;
	@Column(name = "resource_name", length = 45)
	private String resourceName;
	private int total_qty;
	private int occupy_qty;
	private int remaining_qty;
}