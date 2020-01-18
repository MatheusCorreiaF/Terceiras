package com.redfield.terceiras.centralterceirasservice.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.redfield.terceiras.centralterceirasservice.model.OrdemServico;
import com.redfield.terceiras.centralterceirasservice.model.Terceira;
import com.redfield.terceiras.centralterceirasservice.repository.OrdemServicoRepository;
import com.redfield.terceiras.centralterceirasservice.repository.TerceiraRepository;
import com.redfield.terceiras.centralterceirasservice.service.CentralTerceirasService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping("/api/central-terceiras")
@Api(value = "API Rest para serviço relacionados as terceirizadas")
public class CentralTerceirasController {

	@Autowired
	private OrdemServicoRepository osR;
	@Autowired
	private CentralTerceirasService ctS;
	@Autowired
	private TerceiraRepository terceiraR;
	
	@PostMapping("")
	@ApiOperation(value = "Delega uma Terceirizada para a OS")
	@ResponseStatus(HttpStatus.CREATED)
	public OrdemServico delegaTercerizada(@RequestBody OrdemServico os) throws JsonProcessingException {
		Terceira terceira = ctS.delegaTerceirizada();
		os.setTerceira(terceira);
		os = osR.save(os);
		return os;
	}

	@GetMapping("/terceira/{cnpj}/os")
	@ApiOperation(value = "Lista as OS pelo CNPJ da Terceirizada responsável")
	public List<OrdemServico> getOS(@NotNull @PathVariable(value = "cnpj") String cnpj) {
		System.out.println("-----------------------------");
		return osR.findByTerceiraCnpj(cnpj);
	}
	
	@PutMapping("")
	@ApiOperation(value = "Atualiza OS")
	public OrdemServico updateOS(@RequestBody OrdemServico os) throws JsonProcessingException
	{
		return ctS.atualizaOS(os);
	}
	
	
	@GetMapping("/terceira")
	@ApiOperation(value="Lista as Terceirizadas")
	public List<Terceira> getTerceiras() { 
		return terceiraR.findAll(); 
	}
	 

	/*
	 * @GetMapping("/terceira/{cnpj}")
	 * 
	 * @ApiOperation(value = "Busca Terceirizada por CNPJ") public Terceira
	 * getTerceira(@NotNull @PathVariable(value = "cnpj") String cnpj) { return
	 * terceiraR.findByCnpj(cnpj).get(); }
	 */

}
