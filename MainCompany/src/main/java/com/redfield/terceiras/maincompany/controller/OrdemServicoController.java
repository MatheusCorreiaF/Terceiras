package com.redfield.terceiras.maincompany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.redfield.terceiras.maincompany.FilaOSProxy;
import com.redfield.terceiras.maincompany.model.OrdemServico;
import com.redfield.terceiras.maincompany.repository.ClienteRepository;
import com.redfield.terceiras.maincompany.repository.OrdemServicoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/os")
@Api(value="API Rest Ordem de Serviço")
public class OrdemServicoController {

	@Autowired
	private OrdemServicoRepository osR;
	@Autowired
	private ClienteRepository clienteR;
	
	@Autowired
	private FilaOSProxy filaOSP;
	
	@PostMapping("")
	@ApiOperation(value="Adiciona Ordem de Serviço")
	@ResponseStatus(HttpStatus.CREATED)
	public OrdemServico addOS(@RequestBody OrdemServico os) {
		if(clienteR.findByUc(os.getUc()) == null)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente não encontrado!");
		os.setStatus("Pendente");
		OrdemServico osThis = osR.save(os);
		filaOSP.addOSaFila(osThis);
		return osThis;
	}
	
	@GetMapping("")
	@ApiOperation(value="Lista de Ordens de Serviço")
	public List<OrdemServico> getOS() {
		return osR.findAll();
	}
	
}
