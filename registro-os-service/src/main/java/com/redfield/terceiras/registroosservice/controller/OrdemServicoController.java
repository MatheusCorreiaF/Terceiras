package com.redfield.terceiras.registroosservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redfield.terceiras.registroosservice.MainCompanyProxy;
import com.redfield.terceiras.registroosservice.model.OrdemServico;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/registro-os")
@Api(value = "API Rest Registro OS")
@CrossOrigin
public class OrdemServicoController {

	@Autowired
	private MainCompanyProxy mcP;

	@PostMapping("")
	@ApiOperation(value = "Encaminha dados da OS para a central")
	public OrdemServico registraOS(@RequestBody OrdemServico os) {
		return mcP.addOS(os);
	}
}
