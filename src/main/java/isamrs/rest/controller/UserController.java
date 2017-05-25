package isamrs.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import isamrs.rest.domain.User;
import isamrs.rest.service.UserService;

public class UserController {
	
	private UserService userService;
	
	@RequestMapping(
			value = "/user/registration",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> registration(@RequestBody User user) throws Exception{
		User retVal = this.userService.registerUser(user);
		HttpStatus status = null;
		if(retVal != null){
			status = HttpStatus.OK;
		}else{
			status = HttpStatus.OK;
		}
		return new ResponseEntity<User>(retVal, status);
	}
	
	@RequestMapping(
			value = "/user/login",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> login(@RequestParam String email, @RequestParam String password) throws Exception{
		User retVal = this.userService.loginUser(email, password);
		HttpStatus status = null;
		if(retVal != null){
			status = HttpStatus.OK;
		}else{
			status = HttpStatus.OK;
		}
		return new ResponseEntity<User>(retVal, status);
	}

}
