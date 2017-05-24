package isamrs.rest.domain;

import javax.persistence.Entity;

@Entity
public class Restaurant{

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String type;
	
	public Restaurant(){
		
	}
}
