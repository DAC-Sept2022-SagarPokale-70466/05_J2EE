package pojos;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Blog extends BaseEntity {
//productId, name ,price,description,inStock
	@Column(name="title",length = 20,unique = true)
	private String title;
	@Column(name="contents",length = 30)
	private String contents;
	@Column(name="created_time")
	private LocalDateTime createdTime;
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	
	public Blog() {
	}
	public Blog(String title, String contents) {
		this.title = title;
		this.contents = contents;
		this.createdTime = LocalDateTime.now();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public LocalDateTime getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Blog ["+"Category Id="+category.getId()+", title=" + title + ", contents=" + contents + ", createdTime=" + createdTime + "]";
	}
	
}
