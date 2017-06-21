package isamrs.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import isamrs.rest.domain.RestaurantManager;
import isamrs.rest.repository.RestaurantManagerRepository;

@Service
public class RestaurantManagerServiceImpl implements RestaurantManagerService{

	@Autowired
	private RestaurantManagerRepository restaurantManagerRepository;
	
	@Override
	public Page<RestaurantManager> findAll() {
		return restaurantManagerRepository.findAll(null);
	}

	@Override
	public RestaurantManager findOne(Long id) {
		return restaurantManagerRepository.findById(id);
	}
	
	@Override
	public RestaurantManager create(RestaurantManager rm) {
		return restaurantManagerRepository.save(rm);
	}

}
