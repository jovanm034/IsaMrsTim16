package isamrs.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import isamrs.rest.domain.SystemManager;
import isamrs.rest.domain.User;
import isamrs.rest.service.UserService;
import isamrs.rest.validator.UserValidator;

@RestController
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	
	@Autowired
	private UserValidator userValidator;
	
	/*
	@RequestMapping(value = "/registration", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
	}
	*/
	
	@RequestMapping(
			value = "/api/users",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<User>> getUsers() throws Exception{
		logger.info(">>> Getting users");
		Page<User> retVal = this.userService.findAll();
		HttpStatus status = HttpStatus.OK; 
		logger.info("<<< Getting users");
		return new ResponseEntity<Page<User>>(retVal, status);
	}
	
	@RequestMapping(
			value = "/api/user/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUser(@PathVariable("id") Long id) throws Exception{
		logger.info(">>> Getting user");
		User retVal = this.userService.findOne(id);
		HttpStatus status = null;
		if(retVal != null){
			logger.info("==> User found!");
			status = HttpStatus.OK;
		}else{
			logger.info("==> User not found!");
			logger.info(">>> Getting userr");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		logger.info(">>> Getting user");
		return new ResponseEntity<User>(retVal, status);
	}
	
	@RequestMapping(
			value = "/api/users",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createUser(@RequestBody User user) throws Exception{
		logger.info(">>> Creating system manager");
		User retVal = this.userService.create(user);
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
		return new ResponseEntity<User>(retVal, status);
	}
	
	@RequestMapping(
			value = "/user/login",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> login(@RequestBody User user) throws Exception{
		User retVal = this.userService.loginUser(user);
		HttpStatus status = null;
		if(retVal != null){
			System.out.println("USO U OK");
			status = HttpStatus.OK;
			
		}else{
			System.out.println("USO U NOT FOUND");
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<User>(retVal, status);
	}


}
