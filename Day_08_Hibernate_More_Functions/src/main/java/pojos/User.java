package pojos;
/*
 * userId (PK) ,first name,last name , email,password,confirmPassword,role(enum), regAmount;
	 LocalDate/Date regDate;
	 byte[] image;
 */

import java.time.LocalDate;

import javax.persistence.*;//will be importing all annotations from this pkg

@Entity // mandatory cls level annotation meant for hibernate , to tell following is the
		// entity class , to be managed by hib frmwork
@Table(name = "users_tbl") // optional anno , meant to supply table name
public class User {

	@Id // mandatory field or getter(property) level anno : => PK constraint
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto incremented id generation
	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "first_name", length = 20) // col name , varchar size : 20
	private String firstName;

	@Column(name = "last_name", length = 20) // col name , varchar size : 20
	private String lastName;

	@Column(length = 25, unique = true) // unique constraint
	private String email;

	@Column(length = 20, nullable = false) // non null constraint
	private String password;

	@Transient // no col generation(skip from persistence)
	private String confirmPassword;

	@Enumerated(EnumType.STRING) // col type : varchar (enum const name)
	@Column(name = "user_role", length = 30)
	private Role userRole;

	@Column(name = "reg_amount", nullable = false)
	private double regAmount;

	@Column(name = "reg_date", nullable = false)
	private LocalDate regDate;

	@Lob // col type : for mysql : longblob , can store data in MBs.
	private byte[] image;

	// For hibernate : supply def ctor
	public User() {

	}

	public User(String firstName, String lastName, String email, String password, String confirmPassword, Role userRole,
			double regAmount, LocalDate regDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.userRole = userRole;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}

	// lastName,regAmount,regDate
	public User(String lastName, double regAmount, LocalDate regDate) {
		super();
		this.lastName = lastName;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}

	// all setters n getters
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Role getUserRole() {
		return userRole;
	}

	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}

	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", userRole=" + userRole + ", regAmount=" + regAmount + ", regDate=" + regDate + "]";
	}

}
