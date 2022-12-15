package pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart_items")
public class CartItem extends BaseEntity {
//quantity , totalPrice , cart , product
	private int quantity;
	@Column(name = "total_price")
	private double totalPrice;
	// Cart 1<---* CartItem
	@ManyToOne
	@JoinColumn(name = "cart_id", nullable = false)
	private ShoppingCart cart;
	// CartItem 1---->1 Product
	@OneToOne
	@JoinColumn(name="product_id")
	private Product product;

	public CartItem() {
		// TODO Auto-generated constructor stub
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public ShoppingCart getCart() {
		return cart;
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	// toString : exclude : prdouct n cart
	@Override
	public String toString() {
		return "CartItem ID " + getId() + " [quantity=" + quantity + ", totalPrice=" + totalPrice + "]";
	}

}
