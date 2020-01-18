package com.redfield.terceiras.centralterceirasservice.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.redfield.terceiras.centralterceirasservice.model.OrdemServico;
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long>{

	List<OrdemServico> findByTerceiraCnpj(@NotNull String cnpj); 
	
	@Query("select os from OrdemServico os where os.terceira.cnpj = ?1 and os.status != 'Concluido'")
	List<OrdemServico> listaOSnaoConcluidas(@NotNull String cnpj);

}
