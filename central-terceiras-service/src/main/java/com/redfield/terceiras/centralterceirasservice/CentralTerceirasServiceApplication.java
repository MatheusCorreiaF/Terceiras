package com.redfield.terceiras.centralterceirasservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CentralTerceirasServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentralTerceirasServiceApplication.class, args);
	}

}
