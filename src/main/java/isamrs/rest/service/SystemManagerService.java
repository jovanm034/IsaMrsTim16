package isamrs.rest.service;

import isamrs.rest.domain.SystemManager;

import org.springframework.data.domain.Page;


public interface SystemManagerService {

	Page<SystemManager> findAll();
	SystemManager findOne(Long id);
	SystemManager create(SystemManager sysm) throws Exception;
	//SystemManager update(SystemManager sysm) throws Exception;
	//void delete(Long id);
}
