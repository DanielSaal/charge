package br.com.dsa.charge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dsa.charge.filter.RegistryFilter;
import br.com.dsa.charge.model.Registry;
import br.com.dsa.charge.model.RegistryStatus;
import br.com.dsa.charge.repository.RegistriesRepository;

@Service
public class RegistryService {

	@Autowired
	RegistriesRepository repository;
	
	public Registry findById(Long id) {
		Optional<Registry> reg = repository.findById(id);

		return reg.get();
	}

	public void save(Registry registry) {
		repository.save(registry);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public String receive(Long id) {
		Registry registry = this.findById(id);
		registry.setStatus(RegistryStatus.RECEIVED);
		this.save(registry);

		return RegistryStatus.RECEIVED.getDescription();
	}

	public List<Registry> findByDescription(RegistryFilter filter) {
		String description = filter.getDescription() == null ? "%" : filter.getDescription();
		return repository.findByDescriptionContaining(description);
	}
}
