package br.com.dsa.charge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dsa.charge.model.Registry;

public interface RegistriesRepository extends JpaRepository<Registry, Long> {

}
