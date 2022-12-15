package pojos;
/*
 * userId (PK) ,first name,last name , email,password,confirmPassword,role(enum), regAmount;
	 LocalDate/Date regDate;
	 byte[] image;
 */

//will be importing all annotations from this pkg
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity // mandatory cls level annotation meant for hibernate , to tell following is the
		// entity class , to be managed by hib freamwork
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

	// For hibernate : supply def ctor
	public User() {

	}

	public User(String firstName, String lastName, String email, String password, Role userRole) {
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

	@Override
	public String toString() {
		return "User ID " + getId() + " [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", userRole=" + userRole + "]";
	}

}
