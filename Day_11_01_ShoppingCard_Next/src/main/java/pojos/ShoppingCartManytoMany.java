//package pojos;
//
//import java.time.LocalDate;
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//@Entity
//@Table(name = "carts")
//public class ShoppingCartManytoMany extends BaseEntity {
////totalItems,totalCartPrice,createdOn,updatedOn
//	@Column(name = "total_items")
//	private int totalItems;
//	@Column(name = "total_cart_price")
//	private double totalCartPrice;
//	@CreationTimestamp // hib annotation to add creation date auto : once @ time of saving the entity
//	@Column(name = "created_on")
//	private LocalDate createdOn;
//	@UpdateTimestamp // hib annotation to update the date auto : @ time of updating cart
//	@Column(name = "last_updated_on")
//	private LocalDate lastUpdatedOn;
//	// Cart HAS-A Customer Cart ----> User
//	// Cart : one , child , owning
//	@OneToOne // def fetch type : EAGER
//	@JoinColumn(name = "customer_id", nullable = false)
//	private User cartOwner;
//	// Cart *--->* Product
//	// many to many : uni dir association
//	// reco collection type : Set
//	@ManyToMany // mandatory , o.w hib throws MappingExc
//	// owning side => the side in which you have configured a join table
//	@JoinTable(name = "cart_items", joinColumns = @JoinColumn(name = "cart_id"), 
//	inverseJoinColumns = @JoinColumn(name = "product_id"))
//	private Set<Product> products = new HashSet<>();
//
//	public ShoppingCartManytoMany() {
//		// TODO Auto-generated constructor stub
//	}
//
//	// getters n setters
//	public int getTotalItems() {
//		return totalItems;
//	}
//
//	public void setTotalItems(int totalItems) {
//		this.totalItems = totalItems;
//	}
//
//	public double getTotalCartPrice() {
//		return totalCartPrice;
//	}
//
//	public void setTotalCartPrice(double totalCartPrice) {
//		this.totalCartPrice = totalCartPrice;
//	}
//
//	public LocalDate getCreatedOn() {
//		return createdOn;
//	}
//
//	public void setCreatedOn(LocalDate createdOn) {
//		this.createdOn = createdOn;
//	}
//
//	public LocalDate getLastUpdatedOn() {
//		return lastUpdatedOn;
//	}
//
//	public void setLastUpdatedOn(LocalDate lastUpdatedOn) {
//		this.lastUpdatedOn = lastUpdatedOn;
//	}
//
//	public User getCartOwner() {
//		return cartOwner;
//	}
//
//	public void setCartOwner(User cartOwner) {
//		this.cartOwner = cartOwner;
//	}
//
//	public Set<Product> getProducts() {
//		return products;
//	}
//
//	public void setProducts(Set<Product> products) {
//		this.products = products;
//	}
//
//	// toString : exclude user
//	@Override
//	public String toString() {
//		return "ShoppingCart ID " + getId() + " [totalItems=" + totalItems + ", totalCartPrice=" + totalCartPrice
//				+ ", createdOn=" + createdOn + ", lastUpdatedOn=" + lastUpdatedOn + "]";
//	}
//
//}
