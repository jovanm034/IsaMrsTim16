package isamrs.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import isamrs.rest.domain.OrderItem;
import isamrs.rest.repository.OrderItemRepository;
@Service
public class OrderItemServiceImpl implements OrderItemService{

	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public Page<OrderItem> findAll() {
		return this.orderItemRepository.findAll(null);
	}

	@Override
	public OrderItem findOne(Long id) {
		return this.orderItemRepository.findById(id);
	}

	@Override
	public OrderItem create(OrderItem oi) throws Exception {
		return this.orderItemRepository.save(oi);
	}

}
