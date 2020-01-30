package com.redfield.terceiras.centralterceirasservice.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redfield.terceiras.centralterceirasservice.model.OrdemServico;
import com.redfield.terceiras.centralterceirasservice.model.Terceira;
import com.redfield.terceiras.centralterceirasservice.repository.OrdemServicoRepository;
import com.redfield.terceiras.centralterceirasservice.repository.TerceiraRepository;

@Service
public class CentralTerceirasService {

	@Value("${fila.response.os}")
	private String filaResponseOS;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private TerceiraRepository terceiraR;

	@Autowired
	private OrdemServicoRepository osR;

	//método que atribui uma Terceira para realizar o serviço
	public Terceira delegaTerceirizada() {
		//lista as Tercerizadas cadastradas
		List<Terceira> terceiras = terceiraR.findAll();
		HashMap<String, List<OrdemServico>> map = new HashMap<String, List<OrdemServico>>();
		List<Integer> qtde = new ArrayList<Integer>();
		//cria um dicionário <cnpjTerceirizada,lista de OS atribuídas a ela>
		for (int i = 0; i < terceiras.size(); i++) {
			map.put(terceiras.get(i).getCnpj(), osR.listaOSnaoConcluidas(terceiras.get(i).getCnpj()));
			qtde.add(map.get(terceiras.get(i).getCnpj()).size());
		}
		Collections.sort(qtde);
		for(int i=0;i<terceiras.size();i++)
		{
			//delega o serviço para quem tiver menos OS em aberto
			if(map.get(terceiras.get(i).getCnpj()).size() == qtde.get(0))
				return terceiras.get(i);
		}
		return null;
	}
	//método que atualiza a Ordem de serviço e salva no DB
	public OrdemServico atualizaOS(OrdemServico os) throws JsonProcessingException {
		os=osR.save(os);
		ObjectMapper obj = new ObjectMapper();
		String json = obj.writeValueAsString(os);
		rabbitTemplate.convertAndSend(filaResponseOS, json);
		return os;
	}
}
