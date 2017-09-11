package isamrs.rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import isamrs.rest.domain.Drink;

public interface DrinkRepository extends Repository<Drink, Long>{

	public Page<Drink> findAll(Pageable pageable);
	public Drink findById(Long id);
	public Drink save(Drink drink);
}
