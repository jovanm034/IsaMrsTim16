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
	
	
	public Reservation() {
		
	}
	

	public Reservation(Long id, String userEmail, String date, String time) {
		super();
		this.id = id;
		this.userEmail = userEmail;
		this.date = date;
		this.time = time;
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
	
	
	
	
}
