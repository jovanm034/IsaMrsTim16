package isamrs.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import isamrs.rest.domain.Order;
import isamrs.rest.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Page<Order> findAll() {
		return this.orderRepository.findAll(null);
	}

	@Override
	public Order findOne(Long id) {
		return this.orderRepository.findById(id);
	}

	@Override
	public Order create(Order order) throws Exception {
		return this.orderRepository.save(order);
	}
}
