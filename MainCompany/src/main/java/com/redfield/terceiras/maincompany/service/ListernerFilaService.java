package com.redfield.terceiras.maincompany.service;

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
import com.redfield.terceiras.maincompany.model.OrdemServico;
import com.redfield.terceiras.maincompany.repository.OrdemServicoRepository;

@Service
public class ListernerFilaService {

	@Autowired
	private OrdemServicoRepository osR;

	//@Autowired
	//private CentralTerceirasService ctS;

	@Value("${fila.response.os}")
	private String filaResponseOS;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	//@HystrixCommand(fallbackMethod = "republicOnMessage")
	@RabbitListener(queues = "${fila.response.os}")
	public void onMessage(Message message) throws JsonParseException, JsonMappingException, IOException {

		String json = new String(message.getBody(), "UTF-8");

		System.out.println("Mensagem recebida:" + json);

		ObjectMapper mapper = new ObjectMapper();
		OrdemServico osFromFila = mapper.readValue(json, OrdemServico.class);

		osR.save(osFromFila);
	}

	public void republicOnMessage(Message message) throws JsonParseException, JsonMappingException, IOException {
		System.out.println("Republicando mensagem...");
		rabbitTemplate.convertAndSend(filaResponseOS, message);
	}

}
