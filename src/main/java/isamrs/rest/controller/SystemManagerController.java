package isamrs.rest.controller;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import isamrs.rest.service.SystemManagerService;

import isamrs.rest.domain.SystemManager;
import isamrs.rest.domain.RestaurantManager;
import isamrs.rest.domain.Restaurant;

@RestController
public class SystemManagerController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SystemManagerService systemManagerService;

	@RequestMapping(
			value = "/systemManager/addSystemManager",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SystemManager> addSystemManager(@RequestBody SystemManager systemManager) throws Exception{
		logger.info(">>> Adding system manager");
		
		SystemManager retVal = this.systemManagerService.addSystemManager(systemManager);
		HttpStatus status = null;
		if(retVal != null){
			logger.info("==> System manager added!");
			status = HttpStatus.CREATED;
		}else{
			logger.info("==> System manager not added!");
			//PROVERI KOJI STATUS IDE KAD JE DODAVANJE NEUSPESNO
			status = HttpStatus.OK; 
		}
		
		logger.info("<<< Adding system manager");
		return new ResponseEntity<SystemManager>(retVal, status);
		
	}
	
	@RequestMapping(
			value = "/systemManager/addRestaurantManager",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RestaurantManager> addRestaurantManager(@RequestBody RestaurantManager restaurantManager) throws Exception{
		logger.info(">>> Adding restaurant manager");
		RestaurantManager retVal = null;
		HttpStatus status = null;
		logger.info(">>> Adding restaurant manager");
		return new ResponseEntity<RestaurantManager>(retVal, status);
	}
	
	@RequestMapping(
			value = "/systemManager/addRestaurant",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) throws Exception{
		logger.info(">>> Adding restaurant");
		Restaurant retVal = null;
		HttpStatus status = null;
		logger.info(">>> Adding restaurant");
		return new ResponseEntity<Restaurant>(retVal, status);
	}
	
	@RequestMapping(
			value = "/systemManager/login",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SystemManager> login(@RequestBody SystemManager sysm) throws Exception{
		logger.info(">>> System manager login");
		SystemManager retVal = this.systemManagerService.login(sysm);
		HttpStatus status = null;
		if(retVal != null){
			logger.info("==> Login successfull");
			status = HttpStatus.OK;
		}else{
			logger.info("==> Login faild");
			status = HttpStatus.OK;
		}
		logger.info(">>> System manager login");
		return new ResponseEntity<SystemManager>(retVal, status);
	}
	
	
	
	@RequestMapping(value = "/sysmanager/get/{email}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SystemManager> getSystemManager(@PathVariable("email") String email) throws Exception {
		SystemManager retVal = this.systemManagerService.getSystemManager(email);
		return new ResponseEntity<SystemManager>(retVal, HttpStatus.OK);
	}
}
