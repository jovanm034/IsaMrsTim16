package isamrs.rest.service;

import org.springframework.data.domain.Page;

import isamrs.rest.domain.OrderItem;

public interface OrderItemService {
	Page<OrderItem> findAll();
	OrderItem findOne(Long id);
	OrderItem create(OrderItem oi) throws Exception;
}
