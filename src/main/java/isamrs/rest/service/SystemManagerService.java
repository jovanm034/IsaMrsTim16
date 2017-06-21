package isamrs.rest.service;

import isamrs.rest.domain.SystemManager;
import isamrs.rest.domain.RestaurantManager;

import org.springframework.data.domain.Page;

import isamrs.rest.domain.Restaurant;


public interface SystemManagerService {

	Page<SystemManager> findAll();
	SystemManager findOne(Long id);
	SystemManager create(SystemManager sysm) throws Exception;
	//SystemManager update(SystemManager sysm) throws Exception;
	//void delete(Long id);
}
