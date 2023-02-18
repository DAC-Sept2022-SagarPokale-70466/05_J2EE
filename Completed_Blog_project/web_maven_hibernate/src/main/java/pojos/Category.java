package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Category extends BaseEntity {
	@Column(name="title",length = 30,unique = true)
	private String title;
	@Column(length = 50)
	private String description;
	
	//one to many association .  Category 1--->* Product
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Blog> blogs=new ArrayList<>();//Tip : init the collection!
	public Category() {
		// TODO Auto-generated constructor stub
	}
	public Category(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Blog> getProducts() {
		return blogs;
	}
	public void setProducts(List<Blog> blogs) {
		this.blogs = blogs;
	}
	@Override
	public String toString() {
		return "Category ID "+getId()+" [title=" + title + ", description=" + description + "]";
	}
	public void addBlogToCategory(Blog newBlog) {
		blogs.add(newBlog);
		newBlog.setCategory(this);
		
	}
	public void removeBlog (Blog remBlog) {
		blogs.remove(remBlog);
		remBlog.setCategory(null);
		
	}
	
	
}