package isamrs.rest.domain;

import java.io.Serializable;
import org.apache.commons.lang.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Provider implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String firstname;
	@Column(nullable = false)
	private String lastname;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	
	public Provider(){
		
	}
	public Provider(String username, String password){
		super();
		this.username = username;
		this.password = password;
	}
	public Provider(String firstname, String lastname, String username, String password){
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	} 
	
	public Long getId() { return id; };
	public String getFirstname() { return this.firstname; };
	public String getLastname() { return this.lastname; };
	public String getUsername() { return this.username; };
	public String getPassword() { return this.password; };
	
	public void setId(Long id) { this.id = id; };
	public void setFirstname(String firstname) { this.firstname = firstname; };
	public void setLastname(String lastname) { this.lastname = lastname; };
	public void setUsername(String username) { this.username = username; };
	public void setPassword(String password) { this.password = password; };
	
	@Override
	public String toString(){
		return "Provider " + getFirstname() + " " + getLastname() 
		+ " with username " + getUsername() + " and password " + StringUtils.repeat("*", getPassword().length());
	}
}
