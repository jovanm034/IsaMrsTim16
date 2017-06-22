	package isamrs.rest.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import isamrs.rest.domain.SystemManager;
import isamrs.rest.domain.User;

public interface UserRepository extends Repository<User, Long> {
	
	public User findByEmail(String email);
	public List<User> findAll();
	public User save(User user);
	public User findByEmailAndPassword(String email, String password);
	public Page<User> findAll(Pageable pageable);;
	public User findById(Long id);
}
