package com.redfield.terceiras.maincompany.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	@Value("${fila.response.os}")
	private String filaResponseOS;
	@Value("${fila.entrada.os}")
	private String filaEntradaOS;
	
	//cria a fila
	@Bean
	public Queue queueResponse() {
		return new Queue(filaResponseOS,true);
	}
	
	//cria a fila
	@Bean
	public Queue queueEntrada() {
		return new Queue(filaEntradaOS,true);
	}
}
