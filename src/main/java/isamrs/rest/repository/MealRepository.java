package isamrs.rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import isamrs.rest.domain.Meal;

public interface MealRepository extends Repository<Meal, Long>{

	public Page<Meal> findAll(Pageable pageable);
	public Meal findById(Long id);
	public Meal save(Meal meal);
}
