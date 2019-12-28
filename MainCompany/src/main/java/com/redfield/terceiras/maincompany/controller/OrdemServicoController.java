package com.redfield.terceiras.maincompany.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	private RabbitTemplate rabbitTemplate;
	@Value("${fila.entrada.os}")
	private String filaEntradaOS;
	//@Autowired
	//private FilaOSProxy filaOSP;
	
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
	public OrdemServico addOS(@Valid @NotNull @RequestBody OrdemServico os) throws JsonProcessingException {
		if(clienteR.findByUc(os.getUc()) == null)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente não encontrado!");
		os.setStatus("Pendente");
		OrdemServico osThis = osR.save(os);
		ObjectMapper obj = new ObjectMapper();
		String json = obj.writeValueAsString(osThis);
		// adiciona a fila
		rabbitTemplate.convertAndSend(filaEntradaOS, json);
		return osThis;
	}
	
	/*
	 * @GetMapping("")
	 * 
	 * @ApiOperation(value="Lista de Ordens de Serviço") public List<OrdemServico>
	 * getOS() { return osR.findAll(); }
	 */
	
}
