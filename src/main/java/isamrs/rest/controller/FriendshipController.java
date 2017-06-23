package isamrs.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import isamrs.rest.domain.Friendship;

import isamrs.rest.service.FriendshipService;

@RestController
public class FriendshipController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FriendshipService friendshipService;
	
	@RequestMapping(
			value = "/api/friendships",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Friendship>> getFriendship() throws Exception{
		logger.info(">>> Getting users");
		Page<Friendship> retVal = this.friendshipService.findAll();
		HttpStatus status = HttpStatus.OK; 
		logger.info("<<< Getting users");
		return new ResponseEntity<Page<Friendship>>(retVal, status);
	}
	
	@RequestMapping(
			value = "/api/friendship",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Friendship> createFriendship(@RequestBody Friendship friendship) throws Exception{
		logger.info(">>> Creating system manager");
		Friendship retVal = this.friendshipService.create(friendship);
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
		return new ResponseEntity<Friendship>(retVal, status);
	}

}
