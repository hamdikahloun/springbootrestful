package com.kahloun.api.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.kahloun.api")).paths(PathSelectors.regex("/.*")).build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Demo REST API for Tractive", "REST API for Tractive Recruitment.", "API Tractive",
				"Terms of service",
				new Contact("Hamdi Kahloun", "https://api.kahloun.online", "hamdikahlounacil@gmail.com"),
				"https://api.kahloun.online", "API license URL", Collections.emptyList());
	}
}
