package isamrs.rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import isamrs.rest.domain.Restaurant;
import isamrs.rest.domain.RestaurantManager;

public interface RestaurantRepository extends Repository<Restaurant, Long>{

	public Page<Restaurant> findAll(Pageable pageable);
	public Restaurant findByName(String name);
	//public Restaurant save(Restaurant r);
	//public Restaurant update(String name, Restaurant r);
	//public void delete(String name);
	
}