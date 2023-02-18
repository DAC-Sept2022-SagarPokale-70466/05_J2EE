package com.app.pojos;

//will be importing all annotations from this pkg
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
@Table(name = "vehicles")
@Getter
@Setter
@NoArgsConstructor
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vid;

	@Column(length = 20)
	private String vname;

	@Column(length = 50)
	private String company;

	@Column(length = 12)
	private String vnumber;

	@Column(length = 15)
	private String type;

	@ManyToOne
	@JoinColumn(name = "uid", nullable = false)
	private User user;
}