package isamrs.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import isamrs.rest.domain.Order;
import isamrs.rest.service.OrderService;

@RestController
public class OrderController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private OrderService orderService;

	@RequestMapping(
			value = "/api/orders",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Order>> getOrders() throws Exception{
		logger.info(">>> Getting orders");
		Page<Order> retVal = this.orderService.findAll();
		HttpStatus status = HttpStatus.OK; 
		logger.info("<<< Getting orders");
		return new ResponseEntity<Page<Order>>(retVal, status);
	}
	
	@RequestMapping(
			value = "/api/orders/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Order> getOrder(@PathVariable("id") Long id) throws Exception{
		logger.info(">>> Getting order");
		Order retVal = this.orderService.findOne(id);
		HttpStatus status = null;
		if(retVal != null){
			logger.info("==> Order found!");
			status = HttpStatus.OK;
		}else{
			logger.info("==> Order not found!");
			logger.info(">>> Getting order");
			return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
		}
		logger.info(">>> Getting order");
		return new ResponseEntity<Order>(retVal, status);
	}
	
	@RequestMapping(
			value = "/api/orders",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Order> createOrder(@RequestBody Order order) throws Exception{
		logger.info(">>> Creating order");
		Order retVal = this.orderService.create(order);
		HttpStatus status = null;
		if(retVal != null){
			logger.info("==> Order created!");
			status = HttpStatus.CREATED;
		}else{
			logger.info("==> Order not created!");
			//PROVERI KOJI STATUS IDE KAD JE DODAVANJE NEUSPESNO
			status = HttpStatus.OK; 
		}
		logger.info(">>> Creating order");
		return new ResponseEntity<Order>(retVal, status);
	}
}
