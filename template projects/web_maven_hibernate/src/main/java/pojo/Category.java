package pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Category extends BaseEntity {
	@Column(name="category_name",length = 30,unique = true)
	private String categoryName;
	
	@Column(length = 100)
	private String description;
	
//	One to many Associatation catergory 1 --------->* Product
//	Catergory : one, Parent, Non-Owning(=inverse)
	@OneToMany(mappedBy = "productCategory")
	private List<Product> products=new ArrayList<>();//Tip : init the collection!
	
	
	public Category() {
		
	}
	public Category(String categoryName, String description) {
		super();
		this.categoryName = categoryName;
		this.description = description;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Category ID "+getId()+" [categoryName=" + categoryName + ", description=" + description + "]";
	}
	
	
}
