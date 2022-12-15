package pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable // mandatory cls level annotation to tell hib , follwoing class DOES NOT have
			// independent ID , no inde. life cycle, contents are going to be embedded in
			// the owning entity!
public class AdharCard {
	@Column(name="card_no",length = 20,unique = true)
	private String cardNo;
	@Column(length = 30)
	private String location;
	@Column(name="creation_date")
	private LocalDate creationDate;
	/*
	 * @Temporal(TemporalType.DATE)
	 * eg : private Date creationDate;
	 */

	public AdharCard() {
		// TODO Auto-generated constructor stub
	}

	public AdharCard(String cardNo, String location, LocalDate creationDate) {
		super();
		this.cardNo = cardNo;
		this.location = location;
		this.creationDate = creationDate;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "AdharCard [cardNo=" + cardNo + ", location=" + location + ", creationDate=" + creationDate + "]";
	}

}
