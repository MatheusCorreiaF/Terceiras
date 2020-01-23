package com.redfield.terceiras.maincompany.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

@Configuration
public class RabbitMQConfig {

	@Value("${fila.entrada.os}")
	private String filaEntradaOS;
	
	@Bean
    public Queue queue() {
        return new Queue(filaEntradaOS, true);
    }
}
