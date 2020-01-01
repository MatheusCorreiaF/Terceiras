package com.redfield.terceiras.maincompany.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redfield.terceiras.maincompany.model.OrdemServico;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long>{

	List<OrdemServico> findByUc(Long uc);

}
