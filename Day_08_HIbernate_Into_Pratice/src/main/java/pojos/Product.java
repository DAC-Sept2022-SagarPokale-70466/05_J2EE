/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 30-Nov-2022 4:39:49 PM
*/

package pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.type.descriptor.sql.TinyIntTypeDescriptor;

@Entity
@Table(name = "product")
public class Product {

//	id,name,price,description,inStock(boolean),expDate(LocalDate)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "prod_name")
	private String name;

	@Column(name = "prod_desc")
	private String desc;

	@Column(name = "prod_stock", nullable = false, columnDefinition = "boolean default true")
	private boolean inStock;

	@Column(name = "prod_price")
	private double prize;

	@Transient
	LocalDate expDate;

	public Product() {

	}

	public Product(String name, String desc, double prize, LocalDate expDate) {
		this.name = name;
		this.desc = desc;
		this.inStock = true;
		this.prize = prize;
		this.expDate = expDate;
	}

	public double getPrize() {
		return prize;
	}

	public void setPrize(double prize) {
		this.prize = prize;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
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

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", desc=" + desc + ", inStock=" + inStock + ", expDate="
				+ expDate + "]";
	}

}
