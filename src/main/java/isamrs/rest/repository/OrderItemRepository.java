package isamrs.rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import isamrs.rest.domain.OrderItem;

public interface OrderItemRepository extends Repository<OrderItem, Long>{

	public Page<OrderItem> findAll(Pageable pageable);
	public OrderItem findById(Long id);
	public OrderItem save(OrderItem oi);
	
}
