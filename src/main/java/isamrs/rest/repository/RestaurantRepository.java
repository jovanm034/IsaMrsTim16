package isamrs.rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import isamrs.rest.domain.Restaurant;
import isamrs.rest.domain.RestaurantManager;

public interface RestaurantRepository extends Repository<Restaurant, Long>{

	public Page<Restaurant> findAll(Pageable pageable);
	public Restaurant findById(Long id);
	public Restaurant save(Restaurant r);
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("update Restaurant c SET c.name = :restaurantName, c.type = :restaurantType WHERE c.id = :restaurantID")
	public int update(@Param("restaurantID") Long id, @Param("restaurantName") String name, @Param("restaurantType") String type);
	
}
