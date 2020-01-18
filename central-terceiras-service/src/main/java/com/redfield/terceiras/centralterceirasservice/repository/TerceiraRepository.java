package com.redfield.terceiras.centralterceirasservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redfield.terceiras.centralterceirasservice.model.Terceira;

public interface TerceiraRepository extends JpaRepository<Terceira, String>{

	Optional<Terceira> findByCnpj(String cnpj);
}
