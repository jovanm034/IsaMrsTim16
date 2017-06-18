package isamrs.rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;
import isamrs.rest.domain.SystemManager;

public interface SystemManagerRepository extends Repository<SystemManager, Long>{

	public Page<SystemManager> findAll(Pageable pageable);
	public SystemManager findByEmail(String email);
	public SystemManager findByEmailAndPassword(String email, String password);
	public SystemManager save(SystemManager sm);
	
}
