package isamrs.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
			value = "/user/register",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> register(@RequestBody User user) throws Exception{
		User retVal = this.userService.saveUser(user);
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
	
	@RequestMapping(
			value = "/user/all",
			method = RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getAll() throws Exception{
		List<User> retVal = this.userService.getAll();
		HttpStatus status = null;
		if(!retVal.isEmpty()){
			System.out.println("USO U OK");
			status = HttpStatus.OK;
			
		}else{
			System.out.println("USO U NOT FOUND");
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<List<User>>(retVal, status);
	}

}
