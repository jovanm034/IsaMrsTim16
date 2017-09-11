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

import isamrs.rest.domain.Drink;
import isamrs.rest.service.DrinkService;

@RestController
public class DrinkController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DrinkService drinkService;

	@RequestMapping(
			value = "/api/drinks",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Drink>> getDrinks() throws Exception{
		logger.info(">>> Getting drink");
		Page<Drink> retVal = this.drinkService.findAll();
		HttpStatus status = HttpStatus.OK; 
		logger.info("<<< Getting drinks");
		return new ResponseEntity<Page<Drink>>(retVal, status);
	}
	
	@RequestMapping(
			value = "/api/drinks/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Drink> getDrinks(@PathVariable("id") Long id) throws Exception{
		logger.info(">>> Getting drinks");
		Drink retVal = this.drinkService.findOne(id);
		HttpStatus status = null;
		if(retVal != null){
			logger.info("==> Drink found!");
			status = HttpStatus.OK;
		}else{
			logger.info("==> Drink not found!");
			logger.info(">>> Getting drink");
			return new ResponseEntity<Drink>(HttpStatus.NOT_FOUND);
		}
		logger.info(">>> Getting drink");
		return new ResponseEntity<Drink>(retVal, status);
	}
	
	@RequestMapping(
			value = "/api/drinks",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Drink> createDrink(@RequestBody Drink drink) throws Exception{
		logger.info(">>> Creating drink");
		Drink retVal = this.drinkService.create(drink);
		HttpStatus status = null;
		if(retVal != null){
			logger.info("==> Drink created!");
			status = HttpStatus.CREATED;
		}else{
			logger.info("==> Drink not created!");
			//PROVERI KOJI STATUS IDE KAD JE DODAVANJE NEUSPESNO
			status = HttpStatus.OK; 
		}
		logger.info(">>> Creating drink");
		return new ResponseEntity<Drink>(retVal, status);
	}
}