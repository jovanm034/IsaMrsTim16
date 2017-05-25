package isamrs.rest.service;

import isamrs.rest.domain.User;
import isamrs.rest.repository.UserRepository;

public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	@Override
	public User registerUser(User user) throws Exception {
		if(user != userRepository.findByEmail(user.getEmail())){
			userRepository.add(user);
			return user;
		}
		return null;
	}

	@Override
	public User loginUser(String email, String password) throws Exception {
		if(userRepository.findByEmailAndPassword(email, password)!=null){
			User user = userRepository.findByEmailAndPassword(email, password);
			return user;
		}
		return null;
	}

}
