package com.redfield.terceiras.centralterceirasservice.config;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.redfield.terceiras.centralterceirasservice"))// pacote raiz
				.build().apiInfo(metaInfo());
	}

	@SuppressWarnings("rawtypes")
	private ApiInfo metaInfo() {

		ApiInfo apiInfo = new ApiInfo("Central Terceirizadas API REST", "API REST Tercerizadas.", "1.0",
				"Terms of Service",
				new Contact("Matheus Correia", "https://github.com/MatheusCorreiaF", "matheuscf.redfield@gmail.com"),
				"Apache License Version 2.0", "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>());

		return apiInfo;
	}
}