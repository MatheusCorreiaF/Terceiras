package com.redfield.terceiras.maincompany.service;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redfield.terceiras.maincompany.model.OrdemServico;
import com.redfield.terceiras.maincompany.model.Terceira;
import com.redfield.terceiras.maincompany.repository.OrdemServicoRepository;

@Service
public class OrdemServicoService {

	@Autowired
	private OrdemServicoRepository osR;
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Value("${fila.entrada.os}")
	private String filaEntradaOS;

	public OrdemServico addOS(OrdemServico os) throws JsonProcessingException {
		os.setObs("...");
		os.setStatus("Pendente");
		os.setTerceira(new Terceira(null, "A Definir"));
		OrdemServico osThis = osR.save(os);
		ObjectMapper obj = new ObjectMapper();
		String json = obj.writeValueAsString(osThis);
		rabbitTemplate.convertAndSend(filaEntradaOS, json);
		return osThis;
	}

	public List<OrdemServico> listaOSUC(Long uc) {
		return osR.findByUc(uc);
	}
}
