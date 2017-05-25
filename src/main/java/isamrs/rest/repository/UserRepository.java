package isamrs.rest.repository;

import org.springframework.data.repository.Repository;

import isamrs.rest.domain.SystemManager;
import isamrs.rest.domain.User;

public interface UserRepository extends Repository<User, Long> {
	
	public User findByEmail(String email);
	public User find(User user);
	public User findByEmailAndPassword(String email, String password);
	public User save(User user);
	public User add(User user);
}
