package isamrs.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import isamrs.rest.domain.Restaurant;
import isamrs.rest.domain.RestaurantManager;
import isamrs.rest.domain.SystemManager;

import isamrs.rest.repository.SystemManagerRepository;

@Service
public class SystemManagerServiceImpl implements SystemManagerService{

	@Autowired
	private SystemManagerRepository systemManagerRepository;
	
	@Override
	public SystemManager addSystemManager(SystemManager sysm) {
		return this.systemManagerRepository.save(sysm);
	}

	@Override
	public RestaurantManager addRestaurantManager(RestaurantManager resm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restaurant addRestaurant(Restaurant r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SystemManager getSystemManager(String name) throws Exception {
		return this.systemManagerRepository.findByEmail(name);
	}

	
	
}
