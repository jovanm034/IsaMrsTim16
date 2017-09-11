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

import isamrs.rest.domain.OrderItem;
import isamrs.rest.service.OrderItemService;

@RestController
public class OrderItemController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private OrderItemService orderItemService;
	
	@RequestMapping(
			value = "/api/orderItems",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<OrderItem>> getOrderItems() throws Exception{
		logger.info(">>> Getting order items");
		Page<OrderItem> retVal = this.orderItemService.findAll();
		HttpStatus status = HttpStatus.OK; 
		logger.info("<<< Getting order items");
		return new ResponseEntity<Page<OrderItem>>(retVal, status);
	}
	
	@RequestMapping(
			value = "/api/orderItems/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrderItem> getOrderItem(@PathVariable("id") Long id) throws Exception{
		logger.info(">>> Getting order item");
		OrderItem retVal = this.orderItemService.findOne(id);
		HttpStatus status = null;
		if(retVal != null){
			logger.info("==> Order item found!");
			status = HttpStatus.OK;
		}else{
			logger.info("==> Order item not found!");
			logger.info(">>> Getting order item");
			return new ResponseEntity<OrderItem>(HttpStatus.NOT_FOUND);
		}
		logger.info(">>> Getting system manager");
		return new ResponseEntity<OrderItem>(retVal, status);
	}
	
	@RequestMapping(
			value = "/api/orderItems",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItem oi) throws Exception{
		logger.info(">>> Creating order item");
		OrderItem retVal = this.orderItemService.create(oi);
		HttpStatus status = null;
		if(retVal != null){
			logger.info("==> Order item created!");
			status = HttpStatus.CREATED;
		}else{
			logger.info("==> Order item not created!");
			//PROVERI KOJI STATUS IDE KAD JE DODAVANJE NEUSPESNO
			status = HttpStatus.OK; 
		}
		logger.info(">>> Creating order item");
		return new ResponseEntity<OrderItem>(retVal, status);
	}
}
