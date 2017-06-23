	package isamrs.rest.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import isamrs.rest.domain.SystemManager;
import isamrs.rest.domain.User;

public interface UserRepository extends Repository<User, Long> {
	
	public User findByEmail(String email);
	public List<User> findAll();
	public User save(User user);
	public User findByEmailAndPassword(String email, String password);
	public Page<User> findAll(Pageable pageable);;
	public User findById(Long id);
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("update User u SET u.firstName = :userFirstName, u.lastName = :userLastName, u.password = :userPassword, u.passwordConfirm = :userPasswordConfirm WHERE u.id = :userId")
	public int update(@Param("userId") Long id, @Param("userFirstName") String firstName, @Param("userLastName") String lastName, @Param("userPassword") String password, @Param("userPasswordConfirm") String passwordConfirm );
}
