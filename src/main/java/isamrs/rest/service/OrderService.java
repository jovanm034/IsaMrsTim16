package isamrs.rest.service;

import isamrs.rest.domain.Order;

import org.springframework.data.domain.Page;




public interface OrderService {

	Page<Order> findAll();
	Order findOne(Long id);
	Order create(Order order) throws Exception;
}
