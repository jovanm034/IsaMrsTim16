package isamrs.rest.service;



import isamrs.rest.domain.User;


public interface  UserService {
	
	User registerUser(User user) throws Exception;
	User loginUser(String email, String password) throws Exception;



}
