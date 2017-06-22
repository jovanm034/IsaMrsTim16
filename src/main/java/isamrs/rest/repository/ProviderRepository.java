package isamrs.rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import isamrs.rest.domain.Provider;

public interface ProviderRepository extends Repository<Provider, Long>{
	public Page<Provider> findAll(Pageable pageable);
	public Provider findById(Long id);
	public Provider save(Provider p);
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("update Provider c SET c.firstname = :pfirstname, c.lastname = :plastname, c.password = :ppassword, c.logedBefore = :plogedBefore WHERE c.id = :pid")
	public int update(@Param("pid") Long id, @Param("pfirstname") String firstname, @Param("plastname") String lastname, @Param("ppassword") String password, @Param("plogedBefore") int logedBefore);
}
