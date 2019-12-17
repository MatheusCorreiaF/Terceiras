package com.redfield.terceiras.maincompany;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.redfield.terceiras.maincompany.model.OrdemServico;

@FeignClient(name="netflix-zuul-api-gateway-server")
public interface FilaOSProxy {

	@PostMapping("/fila-os-service")
	public OrdemServico addOSaFila(@RequestBody OrdemServico os);	
}
