package pojos;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass // to tell hibernate folllowing is a common super class for all other entities n
// DO NOT create any table for the same !
public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Increment
	private Long id;

//	------------------------------------------------------------------------------------------
	public BaseEntity() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
