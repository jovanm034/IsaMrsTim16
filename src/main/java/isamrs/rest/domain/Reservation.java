package isamrs.rest.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reservation implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String userEmail;
	@Column(nullable = false)
	private String date;
	@Column(nullable = false)
	private String time;
	@Column(nullable = false)
	private String mealType;
	@Column(nullable = false)
	private String drinkType;
	@Column(nullable = false)
	private int total;
	@Column(nullable = false)
	private String resturantName;
	
	
	public Reservation() {
		
	}


	public Reservation(Long id, String userEmail, String date, String time, String mealType, String drinkType,
			int total, String resturantName) {
		super();
		this.id = id;
		this.userEmail = userEmail;
		this.date = date;
		this.time = time;
		this.mealType = mealType;
		this.drinkType = drinkType;
		this.total = total;
		this.resturantName = resturantName;
	}





	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getMealType() {
		return mealType;
	}


	public void setMealType(String mealType) {
		this.mealType = mealType;
	}


	public String getDrinkType() {
		return drinkType;
	}


	public void setDrinkType(String drinkType) {
		this.drinkType = drinkType;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}
	

	public String getResturantName() {
		return resturantName;
	}


	public void setResturantName(String resturantName) {
		this.resturantName = resturantName;
	}


	@Override
	public String toString() {
		return "Reservation [id=" + id + ", userEmail=" + userEmail + ", date=" + date + ", time=" + time
				+ ", mealType=" + mealType + ", drinkType=" + drinkType + ", total=" + total + ", resturantName="
				+ resturantName + "]";
	}

	
}
