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

import isamrs.rest.domain.Meal;
import isamrs.rest.service.MealService;

public class MealController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private MealService mealService;

	@RequestMapping(
			value = "/api/meals",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Meal>> getMeals() throws Exception{
		logger.info(">>> Getting meals");
		Page<Meal> retVal = this.mealService.findAll();
		HttpStatus status = HttpStatus.OK; 
		logger.info("<<< Getting meals");
		return new ResponseEntity<Page<Meal>>(retVal, status);
	}
	
	@RequestMapping(
			value = "/api/meals/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Meal> getMeal(@PathVariable("id") Long id) throws Exception{
		logger.info(">>> Getting meal");
		Meal retVal = this.mealService.findOne(id);
		HttpStatus status = null;
		if(retVal != null){
			logger.info("==> Meal found!");
			status = HttpStatus.OK;
		}else{
			logger.info("==> Meal not found!");
			logger.info(">>> Getting meal");
			return new ResponseEntity<Meal>(HttpStatus.NOT_FOUND);
		}
		logger.info(">>> Getting meal");
		return new ResponseEntity<Meal>(retVal, status);
	}
	
	@RequestMapping(
			value = "/api/meals",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Meal> createMeal(@RequestBody Meal meal) throws Exception{
		logger.info(">>> Creating meal");
		Meal retVal = this.mealService.create(meal);
		HttpStatus status = null;
		if(retVal != null){
			logger.info("==> Meal created!");
			status = HttpStatus.CREATED;
		}else{
			logger.info("==> Meal not created!");
			//PROVERI KOJI STATUS IDE KAD JE DODAVANJE NEUSPESNO
			status = HttpStatus.OK; 
		}
		logger.info(">>> Creating meal");
		return new ResponseEntity<Meal>(retVal, status);
	}
}
