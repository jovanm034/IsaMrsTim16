package isamrs.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import isamrs.rest.domain.SystemManager;
import isamrs.rest.domain.User;
import isamrs.rest.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepository;


	public User saveUser(User user){
		User check = findByEmail(user.getEmail());
		if(check==null){
			this.userRepository.save(user);
			return user;
		}else{
			return null;
		}
	}
    
	public User findByEmail(String email) {
		System.out.println(this.userRepository.findByEmail(email)==null);
        return this.userRepository.findByEmail(email);
    }
	
	public User findByEmailAndPassword(String email, String password){
		System.out.println(this.userRepository.findByEmailAndPassword(email, password)==null);
		System.out.println(this.userRepository.findByEmailAndPassword(email, password).toString());
		return this.userRepository.findByEmailAndPassword(email, password);
	}

	public User loginUser(User user) {
		return findByEmailAndPassword(user.getEmail(), user.getPassword());
		
	}

	public Page<User> findAll() {
		return userRepository.findAll(null);
		
	}
	
	public User findOne(Long id) {
		return userRepository.findById(id);
		
	}

	public User create(User user) {
		return userRepository.save(user);
	}


	public int editUser(Long id, String firstName, String lastName, String password, String passwordConfirm) {
		// TODO Auto-generated method stub
		return userRepository.update(id, firstName, lastName, password, passwordConfirm);
	}

}
