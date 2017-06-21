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

import isamrs.rest.service.SystemManagerService;

import isamrs.rest.domain.SystemManager;

@RestController
public class SystemManagerController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SystemManagerService systemManagerService;

	@RequestMapping(
			value = "/api/systemManagers",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<SystemManager>> getSystemManagers() throws Exception{
		logger.info(">>> Getting system managers");
		Page<SystemManager> retVal = this.systemManagerService.findAll();
		HttpStatus status = HttpStatus.OK; 
		logger.info("<<< Getting system managers");
		return new ResponseEntity<Page<SystemManager>>(retVal, status);
	}
	
	@RequestMapping(
			value = "/api/systemManagers/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SystemManager> getSystemManager(@PathVariable("id") Long id) throws Exception{
		logger.info(">>> Getting system manager");
		SystemManager retVal = this.systemManagerService.findOne(id);
		HttpStatus status = null;
		if(retVal != null){
			logger.info("==> System manager found!");
			status = HttpStatus.OK;
		}else{
			logger.info("==> System manager not found!");
			logger.info(">>> Getting system manager");
			return new ResponseEntity<SystemManager>(HttpStatus.NOT_FOUND);
		}
		logger.info(">>> Getting system manager");
		return new ResponseEntity<SystemManager>(retVal, status);
	}
	
	@RequestMapping(
			value = "/api/systemManagers",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SystemManager> createSystemManager(@RequestBody SystemManager sysm) throws Exception{
		logger.info(">>> Creating system manager");
		SystemManager retVal = this.systemManagerService.create(sysm);
		HttpStatus status = null;
		if(retVal != null){
			logger.info("==> System manager created!");
			status = HttpStatus.CREATED;
		}else{
			logger.info("==> System manager not created!");
			//PROVERI KOJI STATUS IDE KAD JE DODAVANJE NEUSPESNO
			status = HttpStatus.OK; 
		}
		logger.info(">>> Creating system manager");
		return new ResponseEntity<SystemManager>(retVal, status);
	}
	
}
