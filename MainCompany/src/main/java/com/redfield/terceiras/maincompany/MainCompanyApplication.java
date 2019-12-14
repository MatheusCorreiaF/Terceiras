package com.redfield.terceiras.maincompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MainCompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainCompanyApplication.class, args);
	}

}
