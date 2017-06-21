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

import isamrs.rest.domain.Restaurant;
import isamrs.rest.domain.SystemManager;
import isamrs.rest.service.RestaurantService;

@RestController
public class RestaurantController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RestaurantService restaurantService;
	
	@RequestMapping(
			value = "/api/restaurants",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Restaurant>> getRestaurants() throws Exception{
		logger.info(">>> Getting restaurants");
		Page<Restaurant> retVal = this.restaurantService.findAll();
		HttpStatus status = HttpStatus.OK; 
		logger.info("<<< Getting restaurants");
		return new ResponseEntity<Page<Restaurant>>(retVal, status);
	}
	
	@RequestMapping(
			value = "/api/restaurants/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Restaurant> getRestaurant(@PathVariable("id") Long id) throws Exception{
		logger.info(">>> Getting restaurant");
		Restaurant retVal = this.restaurantService.findOne(id);
		HttpStatus status = null;
		if(retVal != null){
			logger.info("==> Restaurant found!");
			status = HttpStatus.OK;
		}else{
			logger.info("==> Restaurant not found!");
			logger.info(">>> Getting restaurant");
			return new ResponseEntity<Restaurant>(HttpStatus.NOT_FOUND);
		}
		logger.info(">>> Getting restaurant");
		return new ResponseEntity<Restaurant>(retVal, status);
	}
	
	@RequestMapping(
			value = "/api/restaurants",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant r) throws Exception{
		logger.info(">>> Creating restaurant");
		Restaurant retVal = this.restaurantService.create(r);
		HttpStatus status = null;
		if(retVal != null){
			logger.info("==> Restaurant created!");
			status = HttpStatus.CREATED;
		}else{
			logger.info("==> Restaurant not created!");
			//PROVERI KOJI STATUS IDE KAD JE DODAVANJE NEUSPESNO
			status = HttpStatus.OK; 
		}
		logger.info(">>> Creating restaurant");
		return new ResponseEntity<Restaurant>(retVal, status);
	}
	
	@RequestMapping(
			value = "/api/restaurants/{id}",
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Restaurant> updateRestaurant(@PathVariable("id") Long id, @RequestBody Restaurant r) throws Exception {
		logger.info(">>> Updating restaurant");
		int num = this.restaurantService.update(id, r.getName(), r.getType());
		if (num == 0) {
			return new ResponseEntity<Restaurant>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info(">>> Updating restaurant");
		return new ResponseEntity<Restaurant>(this.restaurantService.findOne(id), HttpStatus.OK);
	}
}
