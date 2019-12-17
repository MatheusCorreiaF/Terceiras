package com.redfield.terceiras.filaosservice.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redfield.terceiras.filaosservice.model.OrdemServico;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("/")
@Api(value="API Rest Fila de OS")
public class FilaOSController {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Value("${fila.entrada.os}")
	private String filaEntradaOS;

	@PostMapping("")
	@ApiOperation(value="Adiciona Ordem de Serviço a fila")
	public ResponseEntity<OrdemServico> agendaOS(@RequestBody OrdemServico osR) throws JsonProcessingException{

		// 1º-Criar objeto
		OrdemServico os = osR;
		// convertendo o obj compraChaveJson p/ json
		ObjectMapper obj = new ObjectMapper();
		String json = obj.writeValueAsString(os);
		// adiciona a fila
		System.out.println("Teeeeeeeeeeeeeeste rbmq");
		rabbitTemplate.convertAndSend(filaEntradaOS, json);

		
		return new ResponseEntity<OrdemServico>(osR, HttpStatus.OK);
	}
}
