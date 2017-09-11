package isamrs.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import isamrs.rest.domain.Meal;
import isamrs.rest.repository.MealRepository;

@Service
public class MealServiceImpl implements MealService{

	@Autowired
	private MealRepository mealRepository;

	@Override
	public Page<Meal> findAll() {
		return this.mealRepository.findAll(null);
	}

	@Override
	public Meal findOne(Long id) {
		return this.mealRepository.findById(id);
	}

	@Override
	public Meal create(Meal meal) throws Exception {
		return this.mealRepository.save(meal);
	}
}
