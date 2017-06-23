package isamrs.rest.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Friendship implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	@Column(nullable = false)
	public String user1;
	@Column(nullable = false)
	public String user2;
	@Column(nullable = false)
	public int potvrda;
	
	public Friendship(){
		
	}
	
	public Friendship(Long id, String user1, String user2, int potvrda) {
		super();
		this.id = id;
		this.user1 = user1;
		this.user2 = user2;
		this.potvrda = potvrda;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser1() {
		return user1;
	}

	public void setUser1(String user1) {
		this.user1 = user1;
	}

	public String getUser2() {
		return user2;
	}

	public void setUser2(String user2) {
		this.user2 = user2;
	}

	public int getPotvrda() {
		return potvrda;
	}

	public void setPotvrda(int potvrda) {
		this.potvrda = potvrda;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	

}
