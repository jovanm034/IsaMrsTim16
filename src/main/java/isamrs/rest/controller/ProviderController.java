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

import isamrs.rest.domain.Provider;
import isamrs.rest.service.ProviderService;

@RestController
public class ProviderController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProviderService providerService;
	
	@RequestMapping(
			value = "/api/providers",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Provider>> getProviders() throws Exception{
		logger.info(">>> Getting providers");
		Page<Provider> retVal = this.providerService.findAll();
		HttpStatus status = HttpStatus.OK; 
		logger.info("<<< Getting providers");
		return new ResponseEntity<Page<Provider>>(retVal, status);
	}
	
	@RequestMapping(
			value = "/api/providers/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Provider> getProvider(@PathVariable("id") Long id) throws Exception{
		logger.info(">>> Getting provider");
		Provider retVal = this.providerService.findOne(id);
		HttpStatus status = null;
		if(retVal != null){
			logger.info("==> Provider found!");
			status = HttpStatus.OK;
		}else{
			logger.info("==> Provider not found!");
			logger.info(">>> Getting provider");
			return new ResponseEntity<Provider>(HttpStatus.NOT_FOUND);
		}
		logger.info(">>> Getting provider");
		return new ResponseEntity<Provider>(retVal, status);
	}
	
	@RequestMapping(
			value = "/api/providers",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Provider> createProvider(@RequestBody Provider p) throws Exception{
		logger.info(">>> Creating provider");
		Provider retVal = this.providerService.create(p);
		HttpStatus status = null;
		if(retVal != null){
			logger.info("==> Provider created!");
			status = HttpStatus.CREATED;
		}else{
			logger.info("==> Provider not created!");
			//PROVERI KOJI STATUS IDE KAD JE DODAVANJE NEUSPESNO
			status = HttpStatus.OK; 
		}
		logger.info(">>> Creating provider");
		return new ResponseEntity<Provider>(retVal, status);
	}
	
	@RequestMapping(
			value = "/api/providers/{id}",
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Provider> updateProvider(@PathVariable("id") Long id, @RequestBody Provider r) throws Exception {
		logger.info(">>> Updating provider");
		int num = this.providerService.update(id, r.getFirstname(), r.getLastname(), r.getPassword(), r.getLogedBefore());
		if (num == 0) {
			return new ResponseEntity<Provider>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info(">>> Updating provider");
		return new ResponseEntity<Provider>(this.providerService.findOne(id), HttpStatus.OK);
	}
}
