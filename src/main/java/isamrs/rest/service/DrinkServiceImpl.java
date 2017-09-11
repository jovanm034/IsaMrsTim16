package isamrs.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import isamrs.rest.domain.Drink;
import isamrs.rest.repository.DrinkRepository;

@Service
public class DrinkServiceImpl implements DrinkService{

	@Autowired
	private DrinkRepository drinkRepository;
	
	@Override
	public Page<Drink> findAll() {
		return this.drinkRepository.findAll(null);
	}

	@Override
	public Drink findOne(Long id) {
		return this.drinkRepository.findById(id);
	}

	@Override
	public Drink create(Drink drink) throws Exception {
		return this.drinkRepository.save(drink);
	}

}
