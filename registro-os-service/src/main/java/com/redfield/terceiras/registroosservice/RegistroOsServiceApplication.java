package com.redfield.terceiras.registroosservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.redfield.terceiras.registroosservice")
public class RegistroOsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistroOsServiceApplication.class, args);
	}

}
