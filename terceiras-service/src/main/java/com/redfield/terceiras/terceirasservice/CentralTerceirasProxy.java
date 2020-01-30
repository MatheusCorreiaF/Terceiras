package com.redfield.terceiras.terceirasservice;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.redfield.terceiras.terceirasservice.model.OrdemServico;

@FeignClient(name="netflix-zuul-api-gateway-server")
public interface CentralTerceirasProxy {
	//faz a comunicação com a API do serviço central-terceiras-service
	
	@GetMapping("/central-terceiras-service/api/central-terceiras/terceira/{cnpj}/os")
	public List<OrdemServico> getOS(@NotNull @PathVariable(value = "cnpj") String cnpj);

	@PutMapping("/central-terceiras-service/api/central-terceiras")//Os PathVariables são passados para a URL
	public OrdemServico atualizaOS(@RequestBody OrdemServico os);
}
