package isamrs.rest.service;

import org.springframework.data.domain.Page;

import isamrs.rest.domain.RestaurantManager;

public interface RestaurantManagerService {
	
	Page<RestaurantManager> findAll();
	RestaurantManager findOne(Long id);
	RestaurantManager create(RestaurantManager rm);
}
