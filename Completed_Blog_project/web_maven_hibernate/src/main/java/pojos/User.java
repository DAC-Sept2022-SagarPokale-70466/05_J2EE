package pojos;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
//will be importing all annotations from this pkg
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name = "users_tbl") 
public class User extends BaseEntity {

	@Column(name = "full_name", length = 50)
	private String fullName;
	@Column(length = 30, unique = true) // unique constraint
	private String email;
	@Column(length = 20, nullable = false) // non null constraint
	private String password;
	@Column(length = 10, nullable = false)
	private String phoneNo;
	@Column(name="created_time")
	private LocalDateTime createdTime;
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Blog> blogs=new ArrayList<>();
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String fullName, String email, String password, String phoneNo) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.phoneNo = phoneNo;
		this.createdTime = LocalDateTime.now();
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public List<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

	@Override
	public String toString() {
		return "User [fullName=" + fullName + ", email=" + email + ", password=" + password + ", phoneNo=" + phoneNo
				+ ", createdTime=" + createdTime + "]";
	}

	public void addBlogToUser(Blog newBlog) {
		this.blogs.add(newBlog);
		newBlog.setUser(this);
		
	}
	public void removeBlog(Blog remBlog) {
		this.blogs.remove(remBlog);
		remBlog.setUser(null);
		
	}
	

}
