package com.redfield.terceiras.terceirasservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.redfield.terceiras.terceirasservice.CentralTerceirasProxy;
import com.redfield.terceiras.terceirasservice.model.OrdemServico;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping("/terceiras")
@Api(value = "API Rest Terceiras")
public class TerceirasController {
	
	@Autowired
	private CentralTerceirasProxy ctP;
	
	@GetMapping("/cnpj/{cnpj}")
	@ApiOperation(value = "Lista OSs por CNPJ da Terceirizada responsável")
	public List<OrdemServico> getOSs(@PathVariable String cnpj)
	{
		return ctP.getOS(cnpj);
	}
	
	@PutMapping("")
	@ApiOperation(value="Atualiza informaçoes da OS")
	public OrdemServico updateOS(@RequestBody OrdemServico os) throws JsonProcessingException
	{
		return ctP.atualizaOS(os);
	}

}
