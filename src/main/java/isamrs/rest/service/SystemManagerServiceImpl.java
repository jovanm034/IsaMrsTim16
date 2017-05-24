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

import isamrs.rest.repository.SystemManagerRepository;

@Service
public class SystemManagerServiceImpl implements SystemManagerService {

	@Autowired
	private SystemManagerRepository systemManagerRepository;

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

	@Override
	public SystemManager login(SystemManager sysm) throws Exception {
		return this.systemManagerRepository.findByEmailAndPassword(sysm.getEmail(), sysm.getPassword());
	}

}
