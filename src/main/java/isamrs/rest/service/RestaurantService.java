package isamrs.rest.service;

import org.springframework.data.domain.Page;

import isamrs.rest.domain.Restaurant;

public interface RestaurantService {

	Page<Restaurant> findAll();
	Restaurant findOne(Long id);
	Restaurant create(Restaurant sysm) throws Exception;
	int update(Long id, String name, String type) throws Exception;
	//void delete(Long id);
}
