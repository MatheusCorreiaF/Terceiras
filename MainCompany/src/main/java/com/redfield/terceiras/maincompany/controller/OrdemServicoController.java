package com.redfield.terceiras.maincompany.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.redfield.terceiras.maincompany.model.OrdemServico;
import com.redfield.terceiras.maincompany.repository.ClienteRepository;
import com.redfield.terceiras.maincompany.service.OrdemServicoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/os")
@Api(value="API Rest Ordem de Serviço")
@CrossOrigin
public class OrdemServicoController {

	@Autowired
	private ClienteRepository clienteR;
	@Autowired
	private OrdemServicoService osS;
	
	/*
	 * @PostMapping("")
	 * 
	 * @ApiOperation(value="Adiciona Ordem de Serviço")
	 * 
	 * @ResponseStatus(HttpStatus.CREATED) public OrdemServico
	 * addOS(@Valid @NotNull @RequestBody OrdemServico os) {
	 * if(clienteR.findByUc(os.getUc()) == null) throw new
	 * ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente não encontrado!");
	 * os.setStatus("Pendente"); OrdemServico osThis = osR.save(os);
	 * filaOSP.addOSaFila(osThis); return osThis; }
	 */
	
	@PostMapping("")
	@ApiOperation(value="Adiciona Ordem de Serviço")
	@ResponseStatus(HttpStatus.CREATED)
	public OrdemServico addOS(@RequestBody OrdemServico os) throws JsonProcessingException {
		if(clienteR.findByUc(os.getUc()) == null)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente não encontrado!");
		return osS.addOS(os);
	}
	
	@GetMapping("/uc/{uc}")
	@ApiOperation(value="Lista OSs por Unidade Consumidora")
	public List<OrdemServico> getOSsUC(@PathVariable(value = "uc") Long uc)
	{
		return osS.listaOSUC(uc);
	}
	
	
	/*
	 * @GetMapping("")
	 * 
	 * @ApiOperation(value="Lista de Ordens de Serviço") public List<OrdemServico>
	 * getOS() { return osR.findAll(); }
	 */
	
}
