package isamrs.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import isamrs.rest.domain.Restaurant;
import isamrs.rest.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService{

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Override
	public Page<Restaurant> findAll() {
		return restaurantRepository.findAll(null);
	}

	@Override
	public Restaurant findOne(Long id) {
		return restaurantRepository.findById(id);
	}

	@Override
	public Restaurant create(Restaurant r) throws Exception {
		return restaurantRepository.save(r);
	}

	@Override
	public int update(Long id, String name, String type) throws Exception {
		return restaurantRepository.update(id, name, type);
	}

}
