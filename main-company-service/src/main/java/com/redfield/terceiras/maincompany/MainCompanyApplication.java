package com.redfield.terceiras.maincompany;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.redfield.terceiras.maincompany")
public class MainCompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainCompanyApplication.class, args);
	}

}
