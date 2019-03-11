package br.com.dsa.charge.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dsa.charge.model.Registry;

public interface RegistriesRepository extends JpaRepository<Registry, Long> {
	
	public Optional<Registry> findById(Long id);

	public List<Registry> findByDescriptionContaining(String description);

}
