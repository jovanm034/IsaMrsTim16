package isamrs.rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import isamrs.rest.domain.SystemManager;

public interface SystemManagerRepository extends Repository<SystemManager, Long>{

	public Page<SystemManager> findAll(Pageable pageable);
	public SystemManager findById(Long id);
	public SystemManager save(SystemManager sm);
	//@Modifying(clearAutomatically = true)
	//@Query("update SystemManager c set ...")
	//public SystemManager update(String email, SystemManager sm);
	//@Modifying
	//@Transactional
	//@Query(value="delete from SystemManager c where c.id = ?1")
	//public void delete(Long id);
	
}
