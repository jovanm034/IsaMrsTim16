package isamrs.rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;
import isamrs.rest.domain.RestaurantManager;

public interface RestaurantManagerRepository extends Repository<RestaurantManager, Long>{
	
	public Page<RestaurantManager> findAll(Pageable pageable);
	public RestaurantManager findById(Long id);
	public RestaurantManager save(RestaurantManager rm);
}
