package isamrs.rest.domain;

import java.io.Serializable;
import org.apache.commons.lang.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class RestaurantManager implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String firstname;
	@Column(nullable = false)
	private String lastname;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	@ManyToOne(optional = false)
	private Restaurant restaurant;
	
	public RestaurantManager(){
		
	}
	
	public RestaurantManager(String firstname, String lastname, String email, String password, Restaurant restaurant){
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.restaurant = restaurant;
	} 
	
	public Long getId() { return id; };
	public String getFirstname() { return this.firstname; };
	public String getLastname() { return this.lastname; };
	public String getEmail() { return this.email; };
	public String getPassword() { return this.password; };
	public Restaurant getRestaurant() { return this.restaurant; };
	
	public void setId(Long id) { this.id = id; };
	public void setFirstname(String firstname) { this.firstname = firstname; };
	public void setLastname(String lastname) { this.lastname = lastname; };
	public void setEmail(String email) { this.email = email; };
	public void setPassword(String password) { this.password = password; };
	public void setRestaurant(Restaurant restaurant) { this.restaurant = restaurant; };
	
	@Override
	public String toString(){
		return "Restaurant manager " + getFirstname() + " " + getLastname() 
		+ " with email " + getEmail() + " and password " + StringUtils.repeat("*", getPassword().length());
	}
}
