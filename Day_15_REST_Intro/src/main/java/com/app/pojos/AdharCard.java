package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable // mandatory cls level annotation to tell hib , follwoing class DOES NOT have
			// independent ID , no inde. life cycle, contents are going to be embedded in
			// the owning entity!
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AdharCard {
	@Column(name = "card_no", length = 20, unique = true)
	private String cardNo;
	@Column(length = 30)
	private String location;
	@Column(name = "creation_date")
	private LocalDate creationDate;
}
