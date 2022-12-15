package pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="products")
public class Product extends BaseEntity {
//productId, name ,price,description,inStock
	@Column(name="product_name",length = 20,unique = true)
	private String productName;
	private double price;
	@Column(length = 100)
	private String description;
	@Column(name="in_stock")
	private boolean inStock;
	@Transient
	private LocalDate expDate;
	//many-to-one association with Category
	@ManyToOne
	@JoinColumn(name="category_id",nullable = false) //to specify FK col name
	private Category productCategory;
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(String productName , double price, String description, LocalDate expDate) {
		super();
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.expDate = expDate;
		this.inStock=true;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isInStock() {
		return inStock;
	}
	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}
	public LocalDate getExpDate() {
		return expDate;
	}
	public void setExpDate(LocalDate expDate) {
		this.expDate = expDate;
	}
	
	public Category getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(Category productCategory) {
		this.productCategory = productCategory;
	}
	//Tip : DO NOT add any association fields in toString(might cause : recursion!)
	@Override
	public String toString() {
		return "Product ID "+getId()+" [productName=" + productName + ", price=" + price + ", description=" + description
				+ ", inStock=" + inStock + ", expDate=" + expDate + "]";
	}
	
	
}
