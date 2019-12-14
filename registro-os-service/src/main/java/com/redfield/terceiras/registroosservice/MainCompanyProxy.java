package com.redfield.terceiras.registroosservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.redfield.terceiras.registroosservice.model.OrdemServico;

@FeignClient(name="netflix-zuul-api-gateway-server")
public interface MainCompanyProxy {
	
	@PostMapping("/main-company-service/api/os")//Os PathVariables são passados para a URL
	public OrdemServico addOS(@RequestBody OrdemServico os);
	
}
