package isamrs.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import isamrs.rest.domain.SystemManager;
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
