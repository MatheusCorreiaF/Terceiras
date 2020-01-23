package com.redfield.terceiras.centralterceirasservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

@Configuration
public class RabbitMQConfig {

	@Value("${fila.response.os}")
	private String filaResponseOS;
	
	@Bean
    public Queue queueResponse() {
        return new Queue(filaResponseOS, true);
    }
	
	@Value("${fila.entrada.os}")
	private String filaEntradaOS;
	
	@Bean
    public Queue queueEntrada() {
        return new Queue(filaEntradaOS, true);
    }
}
