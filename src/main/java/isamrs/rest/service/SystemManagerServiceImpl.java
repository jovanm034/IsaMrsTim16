package isamrs.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import isamrs.rest.domain.Restaurant;
import isamrs.rest.domain.RestaurantManager;
import isamrs.rest.domain.SystemManager;
import isamrs.rest.repository.RestaurantManagerRepository;
import isamrs.rest.repository.RestaurantRepository;
import isamrs.rest.repository.SystemManagerRepository;

@Service
public class SystemManagerServiceImpl implements SystemManagerService {

	@Autowired
	private SystemManagerRepository systemManagerRepository;
	@Autowired
	private RestaurantManagerRepository restaurantManagerRepository;
	@Autowired
	private RestaurantRepository restaurantRepository;

	@Override
	public SystemManager addSystemManager(SystemManager sysm) {
		List<SystemManager> managers = this.systemManagerRepository.findAll(null).getContent();
		boolean found = false;
		for (int i = 0; i < managers.size(); i++) {
			if (managers.get(i).getEmail().compareTo(sysm.getEmail())==0) {
				found = true;
			}
		}
		if(!found){
			return this.systemManagerRepository.save(sysm);
		}else{
			return null;
		}
			
	}

	@Override
	public RestaurantManager addRestaurantManager(RestaurantManager resm) {
		List<RestaurantManager> managers = this.restaurantManagerRepository.findAll(null).getContent();
		boolean found = false;
		for (int i = 0; i < managers.size(); i++) {
			if (managers.get(i).getEmail().compareTo(resm.getEmail())==0) {
				found = true;
			}
		}
		if(!found){
			return this.restaurantManagerRepository.save(resm);
		}else{
			return null;
		}
	}

	@Override
	public Restaurant addRestaurant(Restaurant r) {
		List<Restaurant> restaurants = this.restaurantRepository.findAll(null).getContent();
		boolean found = false;
		for (int i = 0; i < restaurants.size(); i++) {
			if (restaurants.get(i).getName().compareTo(r.getName())==0) {
				found = true;
			}
		}
		if(!found){
			Restaurant retVal = this.restaurantRepository.save(r);
			//DODAJ KARTU PICA
			//DODAJ JELOVNIK
			//DODAJ KONFIGURACIJU SEDENJA
			return retVal;
		}else{
			return null;
		}
	}

	@Override
	public SystemManager getSystemManager(String name) throws Exception {
		return this.systemManagerRepository.findByEmail(name);
	}

	@Override
	public SystemManager login(SystemManager sysm) throws Exception {
		return this.systemManagerRepository.findByEmailAndPassword(sysm.getEmail(), sysm.getPassword());
	}

}
