package com.app.pojos;
/*
 * userId (PK) ,first name,last name , email,password,confirmPassword,role(enum), regAmount;
	 LocalDate/Date regDate;
	 byte[] image;
 */

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
//will be importing all annotations from this pkg
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity // mandatory cls level annotation meant for hibernate , to tell following is the
		// entity class , to be managed by hib frmwork
@Table(name = "users_tbl") // optional anno , meant to supply table name
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"cart","card","hobbies"})
@JsonInclude(Include.NON_EMPTY)//will not include any null valued or empty properties during ser.
public class User extends BaseEntity {
//first name : can't be blank .(min : 4 chars , max =20 chars)
	@NotBlank(message = "First Name is required")
	@Length(min = 4,max=20,message = "Invalid length of firstName!")
	@Column(name = "first_name", length = 20) // col name , varchar size : 20
	private String firstName;
	@Column(name = "last_name", length = 20) // col name , varchar size : 20
	//last name : can't be blank
	@NotBlank(message = "Last Name is required")
	private String lastName;
	@Column(length = 25, unique = true) // unique constraint
	//valid email format
	@NotBlank(message = "Email required")
	@Email(message = "Invalid email format!")
	private String email;
	@Column(length = 20, nullable = false) // non null constraint
//	@JsonProperty(access = Access.WRITE_ONLY)//skips the field/property during serialization
	//alpha numeric strong password
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})",message = "Invalid Password !")
	private String password;
	@Enumerated(EnumType.STRING) // col type : varchar (enum const name)
	@Column(name = "user_role", length = 30)
	@NotNull(message = "user role must be supplied!")
	private Role userRole;
	// User(Customer) HAS-A Cart User 1---->1 Cart
	@OneToOne(mappedBy = "cartOwner", cascade = CascadeType.ALL, orphanRemoval = true)
@JsonIgnoreProperties(value = "cartOwner")
	private ShoppingCart cart;
	// User HAS-A AdharCard (one-to-one asso between entity n embeddable)
	@Embedded // OPTIONAL anno. simply added for understanding!
	private AdharCard card;
	
	// User HAS-A hobbies : (one-to-many asso between entity n basic value type)
	@ElementCollection // mandatory anno to tell hib , this property is a collection of either basic
						// value type ORcollection of embeddables
	@CollectionTable(name = "hobbies", 
	joinColumns = @JoinColumn(name = "user_id", nullable = false))
	@Column(name="hobby_name",length = 50)
	private List<String> hobbies = new ArrayList<>();

	
	public User(String firstName, String lastName, String email, String password, Role userRole) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.userRole = userRole;
	}
	//helper method : to add cart
	public void addCart(ShoppingCart cart)
	{
		this.cart=cart;
		cart.setCartOwner(this);//bi dir asso done !
	}

	
}
