package isamrs.rest.service;

import org.springframework.data.domain.Page;

import isamrs.rest.domain.Provider;

public interface ProviderService {

	Page<Provider> findAll();
	Provider findOne(Long id);
	Provider create(Provider pr);
	int update(Long id, String firstname, String lastname, String password, int lb);
}
