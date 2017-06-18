package isamrs.rest.domain;

import java.io.Serializable;
import org.apache.commons.lang.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Provider implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String firstname;
	@Column(nullable = false)
	private String lastname;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private int logedBefore;

	public Provider() {

	}

	public Provider(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public Provider(String firstname, String lastname, String email, String password, int lb) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.logedBefore = lb;
	}

	public Long getId() {
		return id;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPassword() {
		return this.password;
	}

	public int getLogedBefore() {
		return this.logedBefore;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setEmail(String email) {
		this.email = email;
	};

	public void setPassword(String password) {
		this.password = password;
	}

	public void setLogedBefore(int lb) {
		this.logedBefore = lb;
	}

	@Override
	public String toString() {
		return "Provider " + getFirstname() + " " + getLastname() + " with email " + getEmail() + " and password "
				+ StringUtils.repeat("*", getPassword().length());
	}
}
