package com.redfield.terceiras.maincompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redfield.terceiras.maincompany.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	Cliente findByUc(long uc);

}
