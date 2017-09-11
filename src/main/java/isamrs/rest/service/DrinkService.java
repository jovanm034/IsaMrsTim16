package isamrs.rest.service;

import org.springframework.data.domain.Page;

import isamrs.rest.domain.Drink;

public interface DrinkService {

	Page<Drink> findAll();
	Drink findOne(Long id);
	Drink create(Drink drink) throws Exception;
}
