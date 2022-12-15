/**
  *	@Developer : Sagar_Pokale
*	@Date		 	   : 29-Nov-2022 3:21:05 PM
*/

package pojo;

import java.time.LocalDate;
import java.util.Arrays;

// Willl be importing all the annotations from this pkg
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity // Mandatory class level annotation meant for hiberinate, to tell following is
		// the entity class, to be managed by hibernate framework
@Table(name = "User_Table")
public class User {

	@Id // Field level annotation or getter(property) level annotations => Primary-key
		// Constraint
	@GeneratedValue(strategy = GenerationType.IDENTITY) // It will add AUTO-INCREMENT id Generation
	@Column(name = "user_id") // Dont use / -
	private Integer userId;

	@Column(name = "first_name", length = 20) // Column name and varchar length
	private String firstName;

	@Column(name = "last_name", length = 20)
	private String lastName;

	@Column(length = 25, unique = true) // UNIQUE CONSTRAINT
	private String email;

	@Column(length = 20, nullable = false) // Non-null Constraint
	private String password;

	@Transient // no Column generation(Skip from persistance)
	private String confirmPassword;

	@Enumerated(EnumType.STRING) // Column type : varchar(enum const name)
	@Column(name = "user_role", length = 30)
	private Role userRole;

	@Column(name = "reg_amount", nullable = false)
	private double regAmount;

	@Column(name = "reg_date", nullable = false)
	private LocalDate regDate;

	@Lob // Column type : for mysql : LongBlob -> can store data in MB's
	private byte[] img;

//	userId (PK) ,name,email,password,confirmPassword,role(enum), regAmount LocalDate/Date regDate byte[] image;
//	For Hibernate Supply default constuctor 
	public User() {
	}

	public User(Integer userId, String firstName, String lastName, String email, String password,
			String confirmPassword, Role userRole, LocalDate regDate) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.userRole = userRole;
		// this.regAmount = regAmount;
		this.regDate = regDate;
	}

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
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", userRole="
				+ userRole + ", regDate=" + regDate + ", img=" + Arrays.toString(img) + "]";
	}

}
