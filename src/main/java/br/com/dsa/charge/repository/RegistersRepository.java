package br.com.dsa.charge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dsa.charge.model.Register;

public interface RegistersRepository extends JpaRepository<Register, Long> {

}
