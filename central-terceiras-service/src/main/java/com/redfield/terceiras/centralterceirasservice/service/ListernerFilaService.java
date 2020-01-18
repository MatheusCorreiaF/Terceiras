package com.redfield.terceiras.centralterceirasservice.service;

import java.io.IOException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.redfield.terceiras.centralterceirasservice.model.OrdemServico;
import com.redfield.terceiras.centralterceirasservice.repository.OrdemServicoRepository;

@Service
public class ListernerFilaService {

	@Autowired
	private OrdemServicoRepository osR;

	@Autowired
	private CentralTerceirasService ctS;

	@Value("${fila.entrada.os}")
	private String filaEntradaOS;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@HystrixCommand(fallbackMethod = "republicOnMessage")
	@RabbitListener(queues = "${fila.entrada.os}")
	public void onMessage(Message message) throws JsonParseException, JsonMappingException, IOException {

		String json = new String(message.getBody(), "UTF-8");

		System.out.println("Mensagem recebida:" + json);

		ObjectMapper mapper = new ObjectMapper();
		OrdemServico osFromFila = mapper.readValue(json, OrdemServico.class);

		osFromFila.setTerceira(ctS.delegaTerceirizada());
		osR.save(osFromFila);
	}

	public void republicOnMessage(Message message) throws JsonParseException, JsonMappingException, IOException {
		System.out.println("Republicando mensagem...");
		rabbitTemplate.convertAndSend(filaEntradaOS, message);
	}

}
