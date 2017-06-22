package isamrs.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import isamrs.rest.domain.Provider;
import isamrs.rest.repository.ProviderRepository;

@Service
public class ProviderServiceImpl implements ProviderService{

	@Autowired
	private ProviderRepository providerRepository;
	
	@Override
	public Page<Provider> findAll() {
		return providerRepository.findAll(null);
	}

	@Override
	public Provider findOne(Long id) {
		return providerRepository.findById(id);
	}

	@Override
	public Provider create(Provider pr) {
		return providerRepository.save(pr);
	}

	@Override
	public int update(Long id, String firstname, String lastname, String password, int lb) {
		return providerRepository.update(id, firstname, lastname, password, lb);
	}

}
