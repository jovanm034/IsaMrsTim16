package isamrs.rest.service;

import org.springframework.data.domain.Page;

import isamrs.rest.domain.Meal;

public interface MealService {

	Page<Meal> findAll();
	Meal findOne(Long id);
	Meal create(Meal meal) throws Exception;
}
