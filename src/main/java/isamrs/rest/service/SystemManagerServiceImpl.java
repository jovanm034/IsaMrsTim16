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

	@Override
	public Page<SystemManager> findAll() {
		return systemManagerRepository.findAll(null);
	}

	@Override
	public SystemManager findOne(Long id) {
		return systemManagerRepository.findById(id);
	}

	@Override
	public SystemManager create(SystemManager sysm) throws Exception {
		return systemManagerRepository.save(sysm);
	}	

}
