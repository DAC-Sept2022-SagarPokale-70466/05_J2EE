package pojos;
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

@Entity // mandatory cls level annotation meant for hibernate , to tell following is the
		// entity class , to be managed by hib frmwork
@Table(name = "users_tbl") // optional anno , meant to supply table name
public class User extends BaseEntity {

	@Column(name = "first_name", length = 20) // col name , varchar size : 20
	private String firstName;
	@Column(name = "last_name", length = 20) // col name , varchar size : 20
	private String lastName;
	@Column(length = 25, unique = true) // unique constraint
	private String email;
	@Column(length = 20, nullable = false) // non null constraint
	private String password;
	@Enumerated(EnumType.STRING) // col type : varchar (enum const name)
	@Column(name = "user_role", length = 30)
	private Role userRole;
	// User(Customer) HAS-A Cart User 1---->1 Cart
	@OneToOne(mappedBy = "cartOwner", cascade = CascadeType.ALL, orphanRemoval = true)
	private ShoppingCart cart;
	// User HAS-A AdharCard (one-to-one asso between entity n embeddable)
	@Embedded // OPTIONAL anno. simply added for understanding!
	private AdharCard card;
	// User HAS-A hobbies : (one-to-many asso between entity n basic value type)
	@ElementCollection // mandatory anno to tell hib , this propert is a collection of either basic
						// value type OR embeddables
	@CollectionTable(name = "hobbies", 
	joinColumns = @JoinColumn(name = "user_id", nullable = false))
	@Column(name="hobby_name",length = 50)
	private List<String> hobbies = new ArrayList<>();

	// For hibernate : supply def ctor
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String firstName, String lastName, String email, String password, Role userRole) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.userRole = userRole;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getUserRole() {
		return userRole;
	}

	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}

	public ShoppingCart getCart() {
		return cart;
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}

	public AdharCard getCard() {
		return card;
	}

	public void setCard(AdharCard card) {
		this.card = card;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "User ID " + getId() + " [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", userRole=" + userRole + "]";
	}

}
