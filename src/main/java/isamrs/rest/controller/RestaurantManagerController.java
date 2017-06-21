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

import isamrs.rest.domain.RestaurantManager;
import isamrs.rest.domain.SystemManager;
import isamrs.rest.service.RestaurantManagerService;

@RestController
public class RestaurantManagerController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RestaurantManagerService restaurantManagerService;
	
	@RequestMapping(
			value = "/api/restaurantManagers",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<RestaurantManager>> getRestaurantManagers() throws Exception{
		logger.info(">>> Getting restaurant managers");
		Page<RestaurantManager> retVal = this.restaurantManagerService.findAll();
		HttpStatus status = HttpStatus.OK;
		logger.info(">>> Getting restaurant managers");
		return new ResponseEntity<Page<RestaurantManager>>(retVal, status);
	}
	
	@RequestMapping(
			value = "/api/restaurantManagers/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RestaurantManager> getRestaurantManager(@PathVariable("id") Long id) throws Exception{
		logger.info(">>> Getting restaurant manager");
		RestaurantManager retVal = this.restaurantManagerService.findOne(id);
		HttpStatus status = null;
		if(retVal != null){
			logger.info("==> Restaurant manager found!");
			status = HttpStatus.OK;
		}else{
			logger.info("==> Restaurant manager not found!");
			logger.info(">>> Getting restaurant manager");
			return new ResponseEntity<RestaurantManager>(HttpStatus.NOT_FOUND);
		}
		logger.info(">>> Getting restaurant manager");
		return new ResponseEntity<RestaurantManager>(retVal, status);
	}
	
	
	@RequestMapping(
			value = "/api/restaurantManagers",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RestaurantManager> createRestaurantManager(@RequestBody RestaurantManager rm) throws Exception{
		logger.info(">>> Creating restaurant manager");
		RestaurantManager retVal = this.restaurantManagerService.create(rm);
		HttpStatus status = null;
		if(retVal != null){
			logger.info("==> Restaurant manager created!");
			status = HttpStatus.CREATED;
		}else{
			logger.info("==> Restaurant manager not created!");
			//PROVERI KOJI STATUS IDE KAD JE DODAVANJE NEUSPESNO
			status = HttpStatus.OK; 
		}
		logger.info(">>> Creating restaurant manager");
		return new ResponseEntity<RestaurantManager>(retVal, status);
	}
}
