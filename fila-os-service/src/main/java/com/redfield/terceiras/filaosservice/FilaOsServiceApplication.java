package com.redfield.terceiras.filaosservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FilaOsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilaOsServiceApplication.class, args);
	}

}
