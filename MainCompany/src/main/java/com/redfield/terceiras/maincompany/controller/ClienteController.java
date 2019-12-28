package com.redfield.terceiras.maincompany.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.redfield.terceiras.maincompany.model.Cliente;
import com.redfield.terceiras.maincompany.repository.ClienteRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/cliente")
@Api(value="API Rest Clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteR;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/*
	 * @PostMapping("")
	 * 
	 * @ApiOperation(value="Adiciona Cliente")
	 * 
	 * @ResponseStatus(HttpStatus.CREATED) public Cliente
	 * addCliente(@Valid @RequestBody Cliente cliente) { logger.info("{}", cliente);
	 * return clienteR.save(cliente); }
	 */
	
	/*
	 * @GetMapping("")
	 * 
	 * @ApiOperation(value="Lista todos Clientes") public List<Cliente>
	 * getClientes() { logger.info("{}", clienteR.findAll()); return
	 * clienteR.findAll(); }
	 */
	
	@GetMapping("/{uc}")
	@ApiOperation(value="Busca Cliente pela Unidade Consumidora")
	public ResponseEntity<Cliente> getEvento(@PathVariable(value = "uc") long uc) {
		Cliente cliente = clienteR.findByUc(uc);
		if (cliente == null)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente não encontrado!");
		logger.info("{}", cliente);
		return ResponseEntity.ok(cliente);
	}
}
