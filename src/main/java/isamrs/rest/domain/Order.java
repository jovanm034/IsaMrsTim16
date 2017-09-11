package isamrs.rest.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private Long restaurantManagerID;
	@Column(nullable = false)
	private Date endDate;
	@Column(nullable = false)
	private boolean active;
	
	public Order(){
		
	}
	
	public Order(Long rmid, Date endd, boolean a){
		super();
		this.restaurantManagerID = rmid;
		this.endDate = endd;
		this.active = a;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", restaurantManagerID=" + restaurantManagerID + ", endDate=" + endDate + ", active="
				+ active + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRestaurantManagerID() {
		return restaurantManagerID;
	}

	public void setRestaurantManagerID(Long restaurantManagerID) {
		this.restaurantManagerID = restaurantManagerID;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
