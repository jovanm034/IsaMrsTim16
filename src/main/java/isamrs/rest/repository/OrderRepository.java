package isamrs.rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import isamrs.rest.domain.Order;

public interface OrderRepository extends Repository<Order, Long>{

	public Page<Order> findAll(Pageable pageable);
	public Order findById(Long id);
	public Order save(Order order);
	
}
