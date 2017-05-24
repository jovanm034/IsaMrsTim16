package isamrs.rest.service;

import isamrs.rest.domain.SystemManager;
import isamrs.rest.domain.RestaurantManager;
import isamrs.rest.domain.Restaurant;


public interface SystemManagerService {

	SystemManager addSystemManager(SystemManager sysm) throws Exception;
	RestaurantManager addRestaurantManager(RestaurantManager resm) throws Exception;
	Restaurant addRestaurant(Restaurant r) throws Exception;
	SystemManager login(SystemManager sysm) throws Exception;
	
	//pomocna
	SystemManager getSystemManager(String name) throws Exception;
}
