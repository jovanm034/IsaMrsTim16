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
	private String dateTime;
	@Column(nullable = false)
	private String table;
	
	public Reservation() {
		
	}

	public Reservation(Long id, String userEmail, String dateTime, String table) {
		super();
		this.id = id;
		this.userEmail = userEmail;
		this.dateTime = dateTime;
		this.table = table;
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

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
