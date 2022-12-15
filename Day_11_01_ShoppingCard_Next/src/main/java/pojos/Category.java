package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
	@Column(name = "category_name", length = 30, unique = true)
	private String categoryName;
	@Column(length = 100)
	private String description;
	// one to many : Category 1 ----->* Product
	//Category : one , parent ,inverse 
	@OneToMany(mappedBy = "productCategory", 
			cascade = CascadeType.ALL, orphanRemoval = true/*
															 * , fetch = FetchType.EAGER
															 */) // Mandatory
																														// annotation
																														// to
																														// specify
																														// one-->
																														// many
																														// multiplicity
	// mappedBy -- mandatory for bi-dir asso. Appears in the inverse(one) side pf
	// the asso.
	// value : name of the asso property , as it appears owning side
	private List<Product> products = new ArrayList<>();// Tip : init the collection!

	public Category() {
		// TODO Auto-generated constructor stub
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
		return "Category ID " + getId() + " [categoryName=" + categoryName + ", description=" + description + "]";
	}

	// helper methods : suggested by Gavin King!
	public void addProduct(Product p) {
		products.add(p);// category --> product
		p.setProductCategory(this);// product --> catgeory
	}

	public void removeProduct(Product p) {
		// removing the bi dir link
		products.remove(p);
		p.setProductCategory(null);
	}

}
